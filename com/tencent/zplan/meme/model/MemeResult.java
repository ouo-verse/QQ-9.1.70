package com.tencent.zplan.meme.model;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.meme.model.Properties;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u0000 22\u00020\u0001:\u0003\u0007\u00159B!\u0012\u0006\u0010,\u001a\u00020(\u0012\u0006\u00101\u001a\u00020\u0003\u0012\b\u00103\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b7\u00108J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u000f\u0010\u0007\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\t\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001a\u0010$\"\u0004\b%\u0010&R\u0017\u0010,\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\u0015\u0010+R\u0017\u00101\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00103\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b/\u0010.\u001a\u0004\b2\u00100R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b-\u0010\u0012R\u0013\u00105\u001a\u0004\u0018\u00010\n8F\u00a2\u0006\u0006\u001a\u0004\b\"\u00104R\u0013\u00106\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b)\u00100\u00a8\u0006:"}, d2 = {"Lcom/tencent/zplan/meme/model/MemeResult;", "", "", "", "frames", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "()V", "toString", "", "hashCode", "other", "", "equals", "", "Lkotlin/Lazy;", "k", "()Ljava/util/List;", "_frames", "Lwx4/d;", "b", "i", "()Lwx4/d;", "statistic", "Lcom/tencent/zplan/meme/model/MemeResult$Sub;", "c", "Lcom/tencent/zplan/meme/model/MemeResult$Sub;", "j", "()Lcom/tencent/zplan/meme/model/MemeResult$Sub;", DomainData.DOMAIN_NAME, "(Lcom/tencent/zplan/meme/model/MemeResult$Sub;)V", "sub", "Lcom/tencent/zplan/meme/model/MemeResult$b;", "d", "Lcom/tencent/zplan/meme/model/MemeResult$b;", "()Lcom/tencent/zplan/meme/model/MemeResult$b;", "l", "(Lcom/tencent/zplan/meme/model/MemeResult$b;)V", "cover", "Lcom/tencent/zplan/meme/action/MemeAction;", "e", "Lcom/tencent/zplan/meme/action/MemeAction;", "()Lcom/tencent/zplan/meme/action/MemeAction;", "action", "f", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "recordKey", h.F, "recordPath", "()Ljava/lang/Integer;", "currentId", "currentRecordKey", "<init>", "(Lcom/tencent/zplan/meme/action/MemeAction;Ljava/lang/String;Ljava/lang/String;)V", "Sub", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class MemeResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy _frames;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Lazy statistic;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Sub sub;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Cover cover;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MemeAction action;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String recordKey;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String recordPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/zplan/meme/model/MemeResult$Sub;", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/zplan/meme/model/e;", "a", "Lkotlin/Lazy;", "()Lcom/tencent/zplan/meme/model/e;", Constants.Service.PROPERTIES, "b", "I", "()I", "subId", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "subKey", "<init>", "(ILjava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final /* data */ class Sub {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Lazy properties;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int subId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String subKey;

        public Sub(int i3, @NotNull String subKey) {
            Intrinsics.checkNotNullParameter(subKey, "subKey");
            this.subId = i3;
            this.subKey = subKey;
            this.properties = LazyKt.lazy(new Function0<Properties>() { // from class: com.tencent.zplan.meme.model.MemeResult$Sub$properties$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Properties invoke() {
                    Properties.Companion companion = Properties.INSTANCE;
                    return companion.a(companion.c(MemeResult.Sub.this.getSubKey()));
                }
            });
        }

        @Nullable
        public final Properties a() {
            return (Properties) this.properties.getValue();
        }

        /* renamed from: b, reason: from getter */
        public final int getSubId() {
            return this.subId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getSubKey() {
            return this.subKey;
        }

        public final boolean d() {
            boolean z16;
            if (this.subId != -1) {
                if (this.subKey.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof Sub) {
                    Sub sub = (Sub) other;
                    if (this.subId != sub.subId || !Intrinsics.areEqual(this.subKey, sub.subKey)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            int i16 = this.subId * 31;
            String str = this.subKey;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "Sub(subId=" + this.subId + ", subKey=" + this.subKey + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/zplan/meme/model/MemeResult$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "path", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.meme.model.MemeResult$b, reason: from toString */
    /* loaded from: classes27.dex */
    public static final /* data */ class Cover {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String path;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String key;

        public Cover(@Nullable String str, @NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.path = str;
            this.key = key;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof Cover) {
                    Cover cover = (Cover) other;
                    if (!Intrinsics.areEqual(this.path, cover.path) || !Intrinsics.areEqual(this.key, cover.key)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            String str = this.path;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            String str2 = this.key;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "Cover(path=" + this.path + ", key=" + this.key + ")";
        }
    }

    public MemeResult(@NotNull MemeAction action, @NotNull String recordKey, @Nullable String str) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        this.action = action;
        this.recordKey = recordKey;
        this.recordPath = str;
        this._frames = LazyKt.lazy(new Function0<List<String>>() { // from class: com.tencent.zplan.meme.model.MemeResult$_frames$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<String> invoke() {
                return new ArrayList();
            }
        });
        this.statistic = LazyKt.lazy(new Function0<wx4.d>() { // from class: com.tencent.zplan.meme.model.MemeResult$statistic$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final wx4.d invoke() {
                Integer d16 = MemeResult.this.d();
                if (d16 != null) {
                    return MemeResult.this.getAction().getStatisticById(d16.intValue());
                }
                return null;
            }
        });
    }

    private final List<String> k() {
        return (List) this._frames.getValue();
    }

    public final void a() {
        k().clear();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final MemeAction getAction() {
        return this.action;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Cover getCover() {
        return this.cover;
    }

    @Nullable
    public final Integer d() {
        int actionId;
        if (this.action.isBatch()) {
            Sub sub = this.sub;
            if (sub != null) {
                actionId = sub.getSubId();
            } else {
                return null;
            }
        } else {
            actionId = this.action.getActionId();
        }
        return Integer.valueOf(actionId);
    }

    @Nullable
    public final String e() {
        if (this.action.isBatch()) {
            Sub sub = this.sub;
            if (sub != null) {
                return sub.getSubKey();
            }
            return null;
        }
        return this.action.getKey();
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MemeResult) {
                MemeResult memeResult = (MemeResult) other;
                if (!Intrinsics.areEqual(this.action, memeResult.action) || !Intrinsics.areEqual(this.recordKey, memeResult.recordKey) || !Intrinsics.areEqual(this.recordPath, memeResult.recordPath)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final List<String> f() {
        List<String> list;
        list = CollectionsKt___CollectionsKt.toList(k());
        return list;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getRecordKey() {
        return this.recordKey;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getRecordPath() {
        return this.recordPath;
    }

    public int hashCode() {
        int i3;
        int i16;
        MemeAction memeAction = this.action;
        int i17 = 0;
        if (memeAction != null) {
            i3 = memeAction.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str = this.recordKey;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str2 = this.recordPath;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i19 + i17;
    }

    @Nullable
    public final wx4.d i() {
        return (wx4.d) this.statistic.getValue();
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final Sub getSub() {
        return this.sub;
    }

    public final void l(@Nullable Cover cover) {
        this.cover = cover;
    }

    public final void m(@Nullable List<String> frames) {
        if (frames != null && !frames.isEmpty()) {
            k().addAll(frames);
        }
    }

    public final void n(@Nullable Sub sub) {
        this.sub = sub;
    }

    @NotNull
    public String toString() {
        return "MemeResult(action=" + this.action + ", recordKey=" + this.recordKey + ", recordPath=" + this.recordPath + ")";
    }
}
