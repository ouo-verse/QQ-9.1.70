package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Cache {
    private static final int defaultMaxEntries = 50000;
    private final CacheMap data;
    private int dclass;
    private int maxcache;
    private int maxncache;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CacheMap extends LinkedHashMap<Name, Object> {
        private int maxsize;

        CacheMap(int i3) {
            super(16, 0.75f, true);
            this.maxsize = i3;
        }

        int getMaxSize() {
            return this.maxsize;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Name, Object> entry) {
            if (this.maxsize >= 0 && size() > this.maxsize) {
                return true;
            }
            return false;
        }

        void setMaxSize(int i3) {
            this.maxsize = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Element {
        int compareCredibility(int i3);

        boolean expired();

        int getType();
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class NegativeElement implements Element {
        int credibility;
        int expire;
        Name name;
        int type;

        public NegativeElement(Name name, int i3, int i16, long j3) {
            this.name = name;
            this.type = i3;
            this.credibility = i16;
            this.expire = Cache.limitExpire(0L, j3);
        }

        @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Cache.Element
        public final int compareCredibility(int i3) {
            return this.credibility - i3;
        }

        @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Cache.Element
        public final boolean expired() {
            if (((int) (System.currentTimeMillis() / 1000)) >= this.expire) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Cache.Element
        public int getType() {
            return this.type;
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            if (this.type == 0) {
                sb5.append("NXDOMAIN ");
                sb5.append(this.name);
            } else {
                sb5.append("NXRRSET ");
                sb5.append(this.name);
                sb5.append(" ");
                sb5.append(Type.string(this.type));
            }
            sb5.append(" cl = ");
            sb5.append(this.credibility);
            return sb5.toString();
        }
    }

    public Cache(int i3) {
        this.maxncache = -1;
        this.maxcache = -1;
        this.dclass = i3;
        this.data = new CacheMap(50000);
    }

    private synchronized void addElement(Name name, Element element) {
        Object obj = this.data.get(name);
        if (obj == null) {
            this.data.put(name, element);
            return;
        }
        int type = element.getType();
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (((Element) list.get(i3)).getType() == type) {
                    list.set(i3, element);
                    return;
                }
            }
            list.add(element);
        } else {
            Element element2 = (Element) obj;
            if (element2.getType() == type) {
                this.data.put(name, element);
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(element2);
                linkedList.add(element);
                this.data.put(name, linkedList);
            }
        }
    }

    private synchronized Element[] allElements(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            return (Element[]) list.toArray(new Element[list.size()]);
        }
        return new Element[]{(Element) obj};
    }

    private synchronized Object exactName(Name name) {
        return this.data.get(name);
    }

    private synchronized Element findElement(Name name, int i3, int i16) {
        Object exactName = exactName(name);
        if (exactName == null) {
            return null;
        }
        return oneElement(name, exactName, i3, i16);
    }

    private List<RRset> findRecords(Name name, int i3, int i16) {
        SetResponse lookupRecords = lookupRecords(name, i3, i16);
        if (lookupRecords.isSuccessful()) {
            return lookupRecords.answers();
        }
        return null;
    }

    private int getCred(int i3, boolean z16) {
        if (i3 == 1) {
            if (z16) {
                return 4;
            }
            return 3;
        }
        if (i3 == 2) {
            if (z16) {
                return 4;
            }
            return 3;
        }
        if (i3 == 3) {
            return 1;
        }
        throw new IllegalArgumentException("getCred: invalid section");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int limitExpire(long j3, long j16) {
        if (j16 >= 0 && j16 < j3) {
            j3 = j16;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) + j3;
        if (currentTimeMillis >= 0 && currentTimeMillis <= TTL.MAX_VALUE) {
            return (int) currentTimeMillis;
        }
        return Integer.MAX_VALUE;
    }

    private static void markAdditional(RRset rRset, Set<Name> set) {
        if (rRset.first().getAdditionalName() == null) {
            return;
        }
        Iterator<Record> it = rRset.rrs().iterator();
        while (it.hasNext()) {
            Name additionalName = it.next().getAdditionalName();
            if (additionalName != null) {
                set.add(additionalName);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x002a, code lost:
    
        if (r0.getType() == r6) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized Element oneElement(Name name, Object obj, int i3, int i16) {
        if (i3 != 255) {
            if (obj instanceof List) {
                for (Element element : (List) obj) {
                    if (element.getType() == i3) {
                        break;
                    }
                }
                element = null;
            } else {
                element = (Element) obj;
            }
            if (element == null) {
                return null;
            }
            if (element.expired()) {
                removeElement(name, i3);
                return null;
            }
            if (element.compareCredibility(i16) < 0) {
                return null;
            }
            return element;
        }
        throw new IllegalArgumentException("oneElement(ANY)");
    }

    private synchronized void removeElement(Name name, int i3) {
        Object obj = this.data.get(name);
        if (obj == null) {
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i16 = 0; i16 < list.size(); i16++) {
                if (((Element) list.get(i16)).getType() == i3) {
                    list.remove(i16);
                    if (list.size() == 0) {
                        this.data.remove(name);
                    }
                    return;
                }
            }
        } else if (((Element) obj).getType() == i3) {
            this.data.remove(name);
        }
    }

    private synchronized void removeName(Name name) {
        this.data.remove(name);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.SetResponse addMessage(com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Message r19) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Cache.addMessage(com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Message):com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.SetResponse");
    }

    public synchronized void addNegative(Name name, int i3, int i16) {
        Element findElement = findElement(name, i3, 0);
        if (findElement != null && findElement.compareCredibility(i16) <= 0) {
            removeElement(name, i3);
        }
    }

    public synchronized <T extends Record> void addRRset(RRset rRset, int i3) {
        CacheRRset cacheRRset;
        long ttl = rRset.getTTL();
        Name name = rRset.getName();
        int type = rRset.getType();
        Element findElement = findElement(name, type, 0);
        if (ttl == 0) {
            if (findElement != null && findElement.compareCredibility(i3) <= 0) {
                removeElement(name, type);
            }
        } else {
            if (findElement != null && findElement.compareCredibility(i3) <= 0) {
                findElement = null;
            }
            if (findElement == null) {
                if (rRset instanceof CacheRRset) {
                    cacheRRset = (CacheRRset) rRset;
                } else {
                    cacheRRset = new CacheRRset(rRset, i3, this.maxcache);
                }
                addElement(name, cacheRRset);
            }
        }
    }

    @Deprecated
    public synchronized void addRecord(Record record, int i3, Object obj) {
        addRecord(record, i3);
    }

    public synchronized void clearCache() {
        this.data.clear();
    }

    public List<RRset> findAnyRecords(Name name, int i3) {
        return findRecords(name, i3, 2);
    }

    public void flushName(Name name) {
        removeName(name);
    }

    public void flushSet(Name name, int i3) {
        removeElement(name, i3);
    }

    public int getDClass() {
        return this.dclass;
    }

    public int getMaxCache() {
        return this.maxcache;
    }

    public int getMaxEntries() {
        return this.data.getMaxSize();
    }

    public int getMaxNCache() {
        return this.maxncache;
    }

    public int getSize() {
        return this.data.size();
    }

    protected synchronized SetResponse lookup(Name name, int i3, int i16) {
        boolean z16;
        boolean z17;
        Name name2;
        int labels = name.labels();
        for (int i17 = labels; i17 >= 1; i17--) {
            if (i17 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i17 == labels) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16) {
                name2 = Name.root;
            } else if (z17) {
                name2 = name;
            } else {
                name2 = new Name(name, labels - i17);
            }
            Object obj = this.data.get(name2);
            if (obj != null) {
                if (z17 && i3 == 255) {
                    SetResponse setResponse = new SetResponse(6);
                    int i18 = 0;
                    for (Element element : allElements(obj)) {
                        if (element.expired()) {
                            removeElement(name2, element.getType());
                        } else if ((element instanceof CacheRRset) && element.compareCredibility(i16) >= 0) {
                            setResponse.addRRset((CacheRRset) element);
                            i18++;
                        }
                    }
                    if (i18 > 0) {
                        return setResponse;
                    }
                } else if (z17) {
                    Element oneElement = oneElement(name2, obj, i3, i16);
                    if (oneElement instanceof CacheRRset) {
                        SetResponse setResponse2 = new SetResponse(6);
                        setResponse2.addRRset((CacheRRset) oneElement);
                        return setResponse2;
                    }
                    if (oneElement != null) {
                        return new SetResponse(2);
                    }
                    Element oneElement2 = oneElement(name2, obj, 5, i16);
                    if (oneElement2 instanceof CacheRRset) {
                        return new SetResponse(4, (CacheRRset) oneElement2);
                    }
                } else {
                    Element oneElement3 = oneElement(name2, obj, 39, i16);
                    if (oneElement3 instanceof CacheRRset) {
                        return new SetResponse(5, (CacheRRset) oneElement3);
                    }
                }
                if (z17 && oneElement(name2, obj, 0, i16) != null) {
                    return SetResponse.ofType(1);
                }
            }
        }
        return SetResponse.ofType(0);
    }

    public SetResponse lookupRecords(Name name, int i3, int i16) {
        return lookup(name, i3, i16);
    }

    public void setMaxCache(int i3) {
        this.maxcache = i3;
    }

    public void setMaxEntries(int i3) {
        this.data.setMaxSize(i3);
    }

    public void setMaxNCache(int i3) {
        this.maxncache = i3;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        synchronized (this) {
            Iterator<Object> it = this.data.values().iterator();
            while (it.hasNext()) {
                for (Element element : allElements(it.next())) {
                    sb5.append(element);
                    sb5.append("\n");
                }
            }
        }
        return sb5.toString();
    }

    public synchronized void addRecord(Record record, int i3) {
        Name name = record.getName();
        int rRsetType = record.getRRsetType();
        if (Type.isRR(rRsetType)) {
            Element findElement = findElement(name, rRsetType, i3);
            if (findElement == null) {
                addRRset(new CacheRRset(record, i3, this.maxcache), i3);
            } else if (findElement.compareCredibility(i3) == 0 && (findElement instanceof CacheRRset)) {
                ((CacheRRset) findElement).addRR(record);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CacheRRset extends RRset implements Element {
        private static final long serialVersionUID = 5971755205903597024L;
        int credibility;
        int expire;

        public CacheRRset(Record record, int i3, long j3) {
            this.credibility = i3;
            this.expire = Cache.limitExpire(record.getTTL(), j3);
            addRR(record);
        }

        @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Cache.Element
        public final int compareCredibility(int i3) {
            return this.credibility - i3;
        }

        @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Cache.Element
        public final boolean expired() {
            if (((int) (System.currentTimeMillis() / 1000)) >= this.expire) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.RRset
        public String toString() {
            return super.toString() + " cl = " + this.credibility;
        }

        public CacheRRset(RRset rRset, int i3, long j3) {
            super(rRset);
            this.credibility = i3;
            this.expire = Cache.limitExpire(rRset.getTTL(), j3);
        }
    }

    public List<RRset> findRecords(Name name, int i3) {
        return findRecords(name, i3, 3);
    }

    public Cache() {
        this(1);
    }
}
