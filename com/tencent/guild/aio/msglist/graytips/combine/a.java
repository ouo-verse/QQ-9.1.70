package com.tencent.guild.aio.msglist.graytips.combine;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0006\u0010\u0010\u001a\u00020\u000bJ\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018J\b\u0010\u001c\u001a\u00020\u000bH\u0016R(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u00188\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b%\u0010\u001f\u00a8\u0006)"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/combine/a;", "Lcom/tencent/guild/aio/msglist/graytips/combine/f;", "Lcom/tencent/guild/aio/msglist/graytips/combine/e;", "grayTipMsgData", "", "j", "preGrayTipMsgData", "curGrayTipMsgData", "i", "Lcom/tencent/guild/aio/msglist/graytips/combine/d;", "combineGrayTipData", "", "g", "c", "b", "a", "d", h.F, "", "combineStatusType", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "grayTipMsgList", "e", "", "grayTipMsgDataList", "", "f", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/List;", "getMLastFocusGrayTipMsgSeqList", "()Ljava/util/List;", "setMLastFocusGrayTipMsgSeqList", "(Ljava/util/List;)V", "mLastFocusGrayTipMsgSeqList", "getMFocusGrayTipMsgDataList", "mFocusGrayTipMsgDataList", "getMCombineGrayTipDataList", "mCombineGrayTipDataList", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class a implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Long> mLastFocusGrayTipMsgSeqList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<e> mFocusGrayTipMsgDataList = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<d> mCombineGrayTipDataList = new ArrayList();

    @Override // com.tencent.guild.aio.msglist.graytips.combine.f
    public void a() {
        this.mLastFocusGrayTipMsgSeqList = f(this.mFocusGrayTipMsgDataList);
        if (this.mFocusGrayTipMsgDataList.size() > 1) {
            d();
            h();
        }
    }

    @Override // com.tencent.guild.aio.msglist.graytips.combine.f
    public void b(@NotNull e grayTipMsgData) {
        Intrinsics.checkNotNullParameter(grayTipMsgData, "grayTipMsgData");
        if (j(grayTipMsgData)) {
            this.mFocusGrayTipMsgDataList.add(grayTipMsgData);
        }
    }

    @Override // com.tencent.guild.aio.msglist.graytips.combine.f
    public void c() {
        this.mFocusGrayTipMsgDataList.clear();
        Iterator<d> it = this.mCombineGrayTipDataList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mCombineGrayTipDataList.clear();
    }

    public final void d() {
        if (this.mFocusGrayTipMsgDataList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mFocusGrayTipMsgDataList.get(0).getMsgItem());
        int size = this.mFocusGrayTipMsgDataList.size();
        for (int i3 = 1; i3 < size; i3++) {
            if (i(this.mFocusGrayTipMsgDataList.get(i3 - 1), this.mFocusGrayTipMsgDataList.get(i3))) {
                arrayList.add(this.mFocusGrayTipMsgDataList.get(i3).getMsgItem());
            } else {
                if (arrayList.size() > 1) {
                    d dVar = new d();
                    dVar.c(new ArrayList(arrayList));
                    this.mCombineGrayTipDataList.add(dVar);
                }
                arrayList.clear();
                arrayList.add(this.mFocusGrayTipMsgDataList.get(i3).getMsgItem());
            }
        }
        if (arrayList.size() > 1) {
            d dVar2 = new d();
            dVar2.c(new ArrayList(arrayList));
            this.mCombineGrayTipDataList.add(dVar2);
        }
    }

    public final void e(@NotNull String combineStatusType, @NotNull List<? extends GuildMsgItem> grayTipMsgList) {
        Intrinsics.checkNotNullParameter(combineStatusType, "combineStatusType");
        Intrinsics.checkNotNullParameter(grayTipMsgList, "grayTipMsgList");
        Iterator<? extends GuildMsgItem> it = grayTipMsgList.iterator();
        while (it.hasNext()) {
            it.next().saveExtInfoToExtStr("guild_gray_tips_combine_status", combineStatusType);
        }
    }

    @NotNull
    public final List<Long> f(@NotNull List<e> grayTipMsgDataList) {
        Intrinsics.checkNotNullParameter(grayTipMsgDataList, "grayTipMsgDataList");
        ArrayList arrayList = new ArrayList();
        Iterator<e> it = grayTipMsgDataList.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getMsgItem().getMsgSeq()));
        }
        return arrayList;
    }

    public abstract void g(@NotNull d combineGrayTipData);

    public void h() {
        int size = this.mCombineGrayTipDataList.size();
        for (int i3 = 0; i3 < size; i3++) {
            g(this.mCombineGrayTipDataList.get(i3));
        }
    }

    public abstract boolean i(@NotNull e preGrayTipMsgData, @NotNull e curGrayTipMsgData);

    public abstract boolean j(@NotNull e grayTipMsgData);

    @Override // com.tencent.guild.aio.msglist.graytips.combine.f
    public void onDestroy() {
        this.mFocusGrayTipMsgDataList.clear();
        this.mLastFocusGrayTipMsgSeqList.clear();
        for (d dVar : this.mCombineGrayTipDataList) {
            e("1", dVar.b());
            dVar.a();
        }
        this.mCombineGrayTipDataList.clear();
    }
}
