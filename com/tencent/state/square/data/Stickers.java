package com.tencent.state.square.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xt4.ac;
import xt4.ad;
import xt4.u;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\u0002\u0010\tJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J3\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0019J\t\u0010 \u001a\u00020\u0006H\u00d6\u0001J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020%J\t\u0010&\u001a\u00020'H\u00d6\u0001J\u0006\u0010(\u001a\u00020\"R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006*"}, d2 = {"Lcom/tencent/state/square/data/Stickers;", "", "items", "", "Lcom/tencent/state/square/data/StickerItem;", "totalNum", "", "likeNums", "Lcom/tencent/state/square/data/LikeNum;", "(Ljava/util/List;ILjava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getLikeNums", "setLikeNums", "getTotalNum", "()I", "setTotalNum", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "getInteractNum", "getLikeNum", "getNewInteractNum", "getNewLikeNum", "hasMyLike", "hashCode", "like", "", "type", "markReaded", "Lcom/tencent/state/square/data/StickerType;", "toString", "", "unlike", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Stickers {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private List<StickerItem> items;
    private List<LikeNum> likeNums;
    private int totalNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/square/data/Stickers$Companion;", "", "Lxt4/ac;", "pb", "Lcom/tencent/state/square/data/Stickers;", "parse", "<init>", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Stickers parse(ac pb5) {
            List emptyList;
            List emptyList2;
            u[] uVarArr;
            ad[] adVarArr;
            if (pb5 == null || (adVarArr = pb5.f448522a) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                emptyList = new ArrayList(adVarArr.length);
                for (ad adVar : adVarArr) {
                    StickerType parse = StickerType.INSTANCE.parse(adVar.f448526a);
                    String str = adVar.f448527b;
                    Intrinsics.checkNotNullExpressionValue(str, "it.icon");
                    emptyList.add(new StickerItem(parse, str, adVar.f448528c, adVar.f448529d, adVar.f448530e));
                }
            }
            int i3 = pb5 != null ? pb5.f448523b : 0;
            if (pb5 == null || (uVarArr = pb5.f448524c) == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                emptyList2 = new ArrayList(uVarArr.length);
                for (u uVar : uVarArr) {
                    emptyList2.add(new LikeNum(uVar.f448652a, uVar.f448653b));
                }
            }
            return new Stickers(emptyList, i3, emptyList2);
        }
    }

    public Stickers(List<StickerItem> items, int i3, List<LikeNum> likeNums) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(likeNums, "likeNums");
        this.items = items;
        this.totalNum = i3;
        this.likeNums = likeNums;
    }

    public final List<StickerItem> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotalNum() {
        return this.totalNum;
    }

    public final List<LikeNum> component3() {
        return this.likeNums;
    }

    public final Stickers copy(List<StickerItem> items, int totalNum, List<LikeNum> likeNums) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(likeNums, "likeNums");
        return new Stickers(items, totalNum, likeNums);
    }

    public final int getInteractNum() {
        return this.totalNum - getLikeNum();
    }

    public final List<StickerItem> getItems() {
        return this.items;
    }

    public final int getLikeNum() {
        Iterator<T> it = this.likeNums.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((LikeNum) it.next()).getNum();
        }
        return i3;
    }

    public final List<LikeNum> getLikeNums() {
        return this.likeNums;
    }

    public final int getNewInteractNum() {
        List<StickerItem> list = this.items;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            StickerItem stickerItem = (StickerItem) obj;
            if (stickerItem.getType() == StickerType.Interact && !stickerItem.getReaded()) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    public final int getNewLikeNum() {
        List<StickerItem> list = this.items;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            StickerItem stickerItem = (StickerItem) obj;
            if (stickerItem.getType() == StickerType.Like && !stickerItem.getReaded()) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    public final int getTotalNum() {
        return this.totalNum;
    }

    public final boolean hasMyLike() {
        Object obj;
        Iterator<T> it = this.items.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            StickerItem stickerItem = (StickerItem) obj;
            if (stickerItem.getType() == StickerType.Like && stickerItem.isMe()) {
                break;
            }
        }
        return obj != null;
    }

    public int hashCode() {
        List<StickerItem> list = this.items;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + this.totalNum) * 31;
        List<LikeNum> list2 = this.likeNums;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void like(int type) {
        Object obj;
        Object obj2;
        List<StickerItem> mutableListOf;
        List<LikeNum> mutableListOf2;
        List<StickerItem> list = this.items;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            StickerItem stickerItem = (StickerItem) next;
            if ((stickerItem.isMe() && stickerItem.getType() == StickerType.Like) ? false : true) {
                arrayList.add(next);
            }
        }
        Object obj3 = null;
        if (arrayList.size() == this.items.size()) {
            this.totalNum++;
        } else {
            Iterator<T> it5 = this.items.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it5.next();
                StickerItem stickerItem2 = (StickerItem) obj;
                if (stickerItem2.isMe() && stickerItem2.getType() == StickerType.Like) {
                    break;
                }
            }
            StickerItem stickerItem3 = (StickerItem) obj;
            Iterator<T> it6 = this.likeNums.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = it6.next();
                    if (stickerItem3 != null && ((LikeNum) obj2).getLikeType() == stickerItem3.getLikeType()) {
                        break;
                    }
                }
            }
            LikeNum likeNum = (LikeNum) obj2;
            if (likeNum != null) {
                likeNum.setNum(likeNum.getNum() - 1);
            }
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new StickerItem(StickerType.Like, "", type, false, true));
        mutableListOf.addAll(arrayList);
        this.items = mutableListOf;
        Iterator<T> it7 = this.likeNums.iterator();
        while (true) {
            if (!it7.hasNext()) {
                break;
            }
            Object next2 = it7.next();
            if (((LikeNum) next2).getLikeType() == type) {
                obj3 = next2;
                break;
            }
        }
        LikeNum likeNum2 = (LikeNum) obj3;
        if (likeNum2 == null) {
            mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(new LikeNum(type, 1));
            mutableListOf2.addAll(this.likeNums);
            this.likeNums = mutableListOf2;
            return;
        }
        likeNum2.setNum(likeNum2.getNum() + 1);
    }

    public final void markReaded(StickerType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        List<StickerItem> list = this.items;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((StickerItem) next).getType() == type) {
                arrayList.add(next);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((StickerItem) it5.next()).setReaded(true);
        }
    }

    public final void setItems(List<StickerItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    public final void setLikeNums(List<LikeNum> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.likeNums = list;
    }

    public final void setTotalNum(int i3) {
        this.totalNum = i3;
    }

    public String toString() {
        return "Stickers(items=" + this.items + ", totalNum=" + this.totalNum + ", likeNums=" + this.likeNums + ")";
    }

    public final void unlike() {
        Object obj;
        Object obj2;
        Iterator<T> it = this.items.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            StickerItem stickerItem = (StickerItem) obj2;
            if (stickerItem.isMe() && stickerItem.getType() == StickerType.Like) {
                break;
            }
        }
        StickerItem stickerItem2 = (StickerItem) obj2;
        if (stickerItem2 != null) {
            List<StickerItem> list = this.items;
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : list) {
                if (!((StickerItem) obj3).isMe()) {
                    arrayList.add(obj3);
                }
            }
            this.items = arrayList;
            this.totalNum--;
            Iterator<T> it5 = this.likeNums.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (((LikeNum) next).getLikeType() == stickerItem2.getLikeType()) {
                    obj = next;
                    break;
                }
            }
            LikeNum likeNum = (LikeNum) obj;
            if (likeNum != null) {
                likeNum.setNum(likeNum.getNum() - 1);
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Stickers)) {
            return false;
        }
        Stickers stickers = (Stickers) other;
        return Intrinsics.areEqual(this.items, stickers.items) && this.totalNum == stickers.totalNum && Intrinsics.areEqual(this.likeNums, stickers.likeNums);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Stickers copy$default(Stickers stickers, List list, int i3, List list2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            list = stickers.items;
        }
        if ((i16 & 2) != 0) {
            i3 = stickers.totalNum;
        }
        if ((i16 & 4) != 0) {
            list2 = stickers.likeNums;
        }
        return stickers.copy(list, i3, list2);
    }
}
