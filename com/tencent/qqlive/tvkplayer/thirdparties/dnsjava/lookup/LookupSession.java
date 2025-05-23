package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.CNAMERecord;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Cache;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.DNAMERecord;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Message;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Name;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.RRset;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Rcode;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Resolver;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.SetResponse;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.NameTooLongException;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.LookupSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
public class LookupSession {
    public static final int DEFAULT_MAX_ITERATIONS = 16;
    public static final int DEFAULT_NDOTS = 1;
    private final Map<Integer, Cache> caches;
    private final boolean cycleResults;
    private final Executor executor;
    private final int maxRedirects;
    private final int ndots;
    private final Resolver resolver;
    private final List<Name> searchPath;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class LookupSessionBuilder {
        private List<Cache> caches;
        private boolean cycleResults;
        private Executor executor;
        private int maxRedirects;
        private int ndots;
        private Resolver resolver;
        private List<Name> searchPath;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Name lambda$build$0(Name name) {
            try {
                return Name.concatenate(name, Name.root);
            } catch (NameTooLongException unused) {
                throw new IllegalArgumentException("Search path name too long");
            }
        }

        public LookupSession build() {
            Stream stream;
            Stream map;
            Collector collection;
            Object collect;
            List<Name> list = this.searchPath;
            if (list != null) {
                stream = list.stream();
                map = stream.map(new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.ad
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        Name lambda$build$0;
                        lambda$build$0 = LookupSession.LookupSessionBuilder.lambda$build$0((Name) obj);
                        return lambda$build$0;
                    }
                });
                collection = Collectors.toCollection(new n());
                collect = map.collect(collection);
                this.searchPath = (List) collect;
            } else {
                this.searchPath = Collections.emptyList();
            }
            return new LookupSession(this.resolver, this.maxRedirects, this.ndots, this.searchPath, this.cycleResults, this.caches, this.executor);
        }

        public LookupSessionBuilder cache(@NonNull Cache cache) {
            if (this.caches == null) {
                this.caches = new ArrayList(1);
            }
            Iterator<Cache> it = this.caches.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Cache next = it.next();
                if (next.getDClass() == cache.getDClass()) {
                    this.caches.remove(next);
                    break;
                }
            }
            this.caches.add(cache);
            return this;
        }

        public LookupSessionBuilder caches(@NonNull Collection<Cache> collection) {
            collection.forEach(new Consumer() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.ac
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    LookupSession.LookupSessionBuilder.this.cache((Cache) obj);
                }
            });
            return this;
        }

        public LookupSessionBuilder clearCaches() {
            List<Cache> list = this.caches;
            if (list != null) {
                list.clear();
            }
            return this;
        }

        public LookupSessionBuilder clearSearchPath() {
            List<Name> list = this.searchPath;
            if (list != null) {
                list.clear();
            }
            return this;
        }

        public LookupSessionBuilder cycleResults(boolean z16) {
            this.cycleResults = z16;
            return this;
        }

        public LookupSessionBuilder executor(Executor executor) {
            this.executor = executor;
            return this;
        }

        public LookupSessionBuilder maxRedirects(int i3) {
            this.maxRedirects = i3;
            return this;
        }

        public LookupSessionBuilder ndots(int i3) {
            this.ndots = i3;
            return this;
        }

        public LookupSessionBuilder resolver(@NonNull Resolver resolver) {
            this.resolver = resolver;
            return this;
        }

        public LookupSessionBuilder searchPath(Name name) {
            if (this.searchPath == null) {
                this.searchPath = new ArrayList();
            }
            this.searchPath.add(name);
            return this;
        }

        LookupSessionBuilder() {
        }

        @Deprecated
        public LookupSessionBuilder caches(@NonNull Map<Integer, Cache> map) {
            return caches(map.values());
        }

        public LookupSessionBuilder searchPath(Collection<? extends Name> collection) {
            if (this.searchPath == null) {
                this.searchPath = new ArrayList();
            }
            this.searchPath.addAll(collection);
            return this;
        }

        @Deprecated
        public LookupSessionBuilder cache(@NonNull Integer num, @NonNull Cache cache) {
            cache(cache);
            return this;
        }
    }

    private static LookupResult buildResult(Message message, List<Name> list, Record record) {
        int rcode = message.getRcode();
        List<Record> section = message.getSection(1);
        if (section.isEmpty() && rcode != 0) {
            if (rcode != 2) {
                if (rcode != 3) {
                    if (rcode != 8) {
                        throw new LookupFailedException(String.format("Unknown non-success error code %s", Rcode.string(rcode)));
                    }
                    throw new NoSuchRRSetException(record.getName(), record.getType());
                }
                throw new NoSuchDomainException(record.getName(), record.getType());
            }
            throw new ServerFailedException();
        }
        return new LookupResult(section, list);
    }

    public static LookupSessionBuilder builder() {
        LookupSessionBuilder lookupSessionBuilder = new LookupSessionBuilder();
        lookupSessionBuilder.maxRedirects = 16;
        lookupSessionBuilder.ndots = 1;
        return lookupSessionBuilder;
    }

    private <T extends Throwable> CompletionStage<LookupResult> completeExceptionally(T t16) {
        CompletableFuture completableFuture = new CompletableFuture();
        completableFuture.completeExceptionally(t16);
        return completableFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$lookupUntilSuccess$3(Iterator it, int i3, int i16, LookupResult lookupResult, Throwable th5) {
        Throwable cause;
        CompletableFuture completedFuture;
        if (th5 == null) {
            cause = null;
        } else {
            cause = th5.getCause();
        }
        if (!(cause instanceof NoSuchDomainException) && !(cause instanceof NoSuchRRSetException)) {
            if (cause == null) {
                completedFuture = CompletableFuture.completedFuture(lookupResult);
                return completedFuture;
            }
            return completeExceptionally(cause);
        }
        if (it.hasNext()) {
            return lookupUntilSuccess(it, i3, i16);
        }
        return completeExceptionally(cause);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SetResponse lambda$lookupWithCache$5(Record record, Cache cache) {
        return cache.lookupRecords(record.getName(), record.getType(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LookupResult lambda$lookupWithResolver$8(List list, Record record, Message message) {
        return buildResult(message, list, record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Stream lambda$setResponseToMessageFuture$10(RRset rRset) {
        Stream stream;
        stream = rRset.rrs(this.cycleResults).stream();
        return stream;
    }

    private CompletionStage<LookupResult> lookupUntilSuccess(final Iterator<Name> it, final int i3, final int i16) {
        CompletionStage thenCompose;
        CompletionStage handle;
        CompletionStage<LookupResult> thenCompose2;
        final Record newRecord = Record.newRecord(it.next(), i3, i16);
        thenCompose = lookupWithCache(newRecord, null).thenCompose(new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                CompletionStage lambda$lookupUntilSuccess$2;
                lambda$lookupUntilSuccess$2 = LookupSession.this.lambda$lookupUntilSuccess$2(newRecord, (LookupResult) obj);
                return lambda$lookupUntilSuccess$2;
            }
        });
        handle = thenCompose.handle(new BiFunction() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.z
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                CompletionStage lambda$lookupUntilSuccess$3;
                lambda$lookupUntilSuccess$3 = LookupSession.this.lambda$lookupUntilSuccess$3(it, i3, i16, (LookupResult) obj, (Throwable) obj2);
                return lambda$lookupUntilSuccess$3;
            }
        });
        thenCompose2 = handle.thenCompose(new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.aa
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                CompletionStage lambda$lookupUntilSuccess$4;
                lambda$lookupUntilSuccess$4 = LookupSession.lambda$lookupUntilSuccess$4((CompletionStage) obj);
                return lambda$lookupUntilSuccess$4;
            }
        });
        return thenCompose2;
    }

    private CompletionStage<LookupResult> lookupWithCache(final Record record, final List<Name> list) {
        Optional ofNullable;
        Optional map;
        Optional map2;
        Object orElseGet;
        ofNullable = Optional.ofNullable(this.caches.get(Integer.valueOf(record.getDClass())));
        map = ofNullable.map(new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                SetResponse lambda$lookupWithCache$5;
                lambda$lookupWithCache$5 = LookupSession.lambda$lookupWithCache$5(Record.this, (Cache) obj);
                return lambda$lookupWithCache$5;
            }
        });
        map2 = map.map(new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.p
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                CompletionStage lambda$lookupWithCache$6;
                lambda$lookupWithCache$6 = LookupSession.this.lambda$lookupWithCache$6(record, list, (SetResponse) obj);
                return lambda$lookupWithCache$6;
            }
        });
        orElseGet = map2.orElseGet(new Supplier() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.q
            @Override // java.util.function.Supplier
            public final Object get() {
                CompletionStage lambda$lookupWithCache$7;
                lambda$lookupWithCache$7 = LookupSession.this.lambda$lookupWithCache$7(record, list);
                return lambda$lookupWithCache$7;
            }
        });
        return (CompletionStage) orElseGet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lookupWithResolver, reason: merged with bridge method [inline-methods] */
    public CompletionStage<LookupResult> lambda$lookupWithCache$7(final Record record, final List<Name> list) {
        CompletionStage thenApply;
        CompletionStage<LookupResult> thenApply2;
        thenApply = this.resolver.sendAsync(Message.newQuery(record), this.executor).thenApply(new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.s
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Message maybeAddToCache;
                maybeAddToCache = LookupSession.this.maybeAddToCache((Message) obj);
                return maybeAddToCache;
            }
        });
        thenApply2 = thenApply.thenApply(new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.t
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                LookupResult lambda$lookupWithResolver$8;
                lambda$lookupWithResolver$8 = LookupSession.lambda$lookupWithResolver$8(list, record, (Message) obj);
                return lambda$lookupWithResolver$8;
            }
        });
        return thenApply2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message maybeAddToCache(final Message message) {
        Optional ofNullable;
        for (RRset rRset : message.getSectionRRsets(1)) {
            if (rRset.getType() == 5 || rRset.getType() == 39) {
                if (rRset.size() != 1) {
                    throw new InvalidZoneDataException("Multiple CNAME RRs not allowed, see RFC1034 3.6.2");
                }
            }
        }
        ofNullable = Optional.ofNullable(this.caches.get(Integer.valueOf(message.getQuestion().getDClass())));
        ofNullable.ifPresent(new Consumer() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.r
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Cache) obj).addMessage(Message.this);
            }
        });
        return message;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: maybeFollowRedirect, reason: merged with bridge method [inline-methods] */
    public CompletionStage<LookupResult> lambda$maybeFollowRedirectsInAnswer$11(LookupResult lookupResult, Record record, int i3) {
        CompletableFuture completedFuture;
        if (i3 <= this.maxRedirects) {
            List<Record> records = lookupResult.getRecords();
            if (records.isEmpty() || record.getType() == records.get(0).getType() || (records.get(0).getType() != 5 && records.get(0).getType() != 39)) {
                completedFuture = CompletableFuture.completedFuture(lookupResult);
                return completedFuture;
            }
            return maybeFollowRedirectsInAnswer(lookupResult, record, i3);
        }
        throw new RedirectOverflowException(this.maxRedirects);
    }

    private CompletionStage<LookupResult> maybeFollowRedirectsInAnswer(LookupResult lookupResult, Record record, int i3) {
        CompletionStage<LookupResult> thenCompose;
        CompletableFuture completedFuture;
        ArrayList arrayList = new ArrayList(lookupResult.getAliases());
        ArrayList arrayList2 = new ArrayList();
        Name name = record.getName();
        for (Record record2 : lookupResult.getRecords()) {
            if (i3 <= this.maxRedirects) {
                if (record2.getDClass() == record.getDClass()) {
                    if (record2.getType() == 5 && name.equals(record2.getName())) {
                        arrayList.add(name);
                        i3++;
                        name = ((CNAMERecord) record2).getTarget();
                    } else if (record2.getType() == 39 && name.subdomain(record2.getName())) {
                        arrayList.add(name);
                        i3++;
                        try {
                            name = name.fromDNAME((DNAMERecord) record2);
                        } catch (NameTooLongException e16) {
                            throw new InvalidZoneDataException("Cannot derive DNAME from " + record2 + " for " + name, e16);
                        }
                    } else if (record2.getType() == record.getType() && name.equals(record2.getName())) {
                        arrayList2.add(record2);
                    }
                }
            } else {
                throw new RedirectOverflowException(this.maxRedirects);
            }
        }
        if (!arrayList2.isEmpty()) {
            completedFuture = CompletableFuture.completedFuture(new LookupResult(arrayList2, arrayList));
            return completedFuture;
        }
        if (i3 <= this.maxRedirects) {
            final int i16 = i3 + 1;
            final Record newRecord = Record.newRecord(name, record.getType(), record.getDClass());
            thenCompose = lookupWithCache(newRecord, arrayList).thenCompose(new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.u
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    CompletionStage lambda$maybeFollowRedirectsInAnswer$11;
                    lambda$maybeFollowRedirectsInAnswer$11 = LookupSession.this.lambda$maybeFollowRedirectsInAnswer$11(newRecord, i16, (LookupResult) obj);
                    return lambda$maybeFollowRedirectsInAnswer$11;
                }
            });
            return thenCompose;
        }
        throw new RedirectOverflowException(this.maxRedirects);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: resolveRedirects, reason: merged with bridge method [inline-methods] */
    public CompletionStage<LookupResult> lambda$lookupUntilSuccess$2(LookupResult lookupResult, Record record) {
        return lambda$maybeFollowRedirectsInAnswer$11(lookupResult, record, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Name safeConcat(Name name, Name name2) {
        try {
            return Name.concatenate(name, name2);
        } catch (NameTooLongException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setResponseToMessageFuture, reason: merged with bridge method [inline-methods] */
    public CompletionStage<LookupResult> lambda$lookupWithCache$6(SetResponse setResponse, Record record, List<Name> list) {
        Stream stream;
        Stream flatMap;
        Collector list2;
        Object collect;
        CompletableFuture completedFuture;
        if (setResponse.isNXDOMAIN()) {
            return completeExceptionally(new NoSuchDomainException(record.getName(), record.getType()));
        }
        if (setResponse.isNXRRSET()) {
            return completeExceptionally(new NoSuchRRSetException(record.getName(), record.getType()));
        }
        if (setResponse.isSuccessful()) {
            stream = setResponse.answers().stream();
            flatMap = stream.flatMap(new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.x
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Stream lambda$setResponseToMessageFuture$10;
                    lambda$setResponseToMessageFuture$10 = LookupSession.this.lambda$setResponseToMessageFuture$10((RRset) obj);
                    return lambda$setResponseToMessageFuture$10;
                }
            });
            list2 = Collectors.toList();
            collect = flatMap.collect(list2);
            completedFuture = CompletableFuture.completedFuture(new LookupResult((List) collect, list));
            return completedFuture;
        }
        return null;
    }

    List<Name> expandName(final Name name) {
        Stream stream;
        Stream map;
        Stream filter;
        Collector collection;
        Object collect;
        if (!name.isAbsolute()) {
            stream = this.searchPath.stream();
            map = stream.map(new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.l
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Name safeConcat;
                    safeConcat = LookupSession.safeConcat(Name.this, (Name) obj);
                    return safeConcat;
                }
            });
            filter = map.filter(new Predicate() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.m
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return k.a((Name) obj);
                }
            });
            collection = Collectors.toCollection(new n());
            collect = filter.collect(collection);
            List<Name> list = (List) collect;
            if (name.labels() > this.ndots) {
                list.add(0, safeConcat(name, Name.root));
            } else {
                list.add(safeConcat(name, Name.root));
            }
            return list;
        }
        return Collections.singletonList(name);
    }

    public CompletionStage<LookupResult> lookupAsync(Name name, int i3) {
        return lookupAsync(name, i3, 1);
    }

    LookupSession(@NonNull Resolver resolver, int i3, int i16, List<Name> list, boolean z16, List<Cache> list2, Executor executor) {
        Stream stream;
        Collector map;
        Object collect;
        Map<Integer, Cache> map2;
        this.resolver = resolver;
        this.maxRedirects = i3;
        this.ndots = i16;
        this.searchPath = list;
        this.cycleResults = z16;
        if (list2 != null) {
            stream = list2.stream();
            map = Collectors.toMap(new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.v
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((Cache) obj).getDClass());
                }
            }, new Function() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.w
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Cache lambda$new$0;
                    lambda$new$0 = LookupSession.lambda$new$0((Cache) obj);
                    return lambda$new$0;
                }
            });
            collect = stream.collect(map);
            map2 = (Map) collect;
        } else {
            map2 = Collections.emptyMap();
        }
        this.caches = map2;
        this.executor = executor == null ? ForkJoinPool.commonPool() : executor;
    }

    public CompletionStage<LookupResult> lookupAsync(Name name, int i3, int i16) {
        return lookupUntilSuccess(expandName(name).iterator(), i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CompletionStage lambda$lookupUntilSuccess$4(CompletionStage completionStage) {
        return completionStage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Cache lambda$new$0(Cache cache) {
        return cache;
    }
}
