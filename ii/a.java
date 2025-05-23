package ii;

import ci.h;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.MediaListInfo;
import com.tencent.qqnt.kernel.nativeinterface.QunMediaRightEnum;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J8\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0004R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010\"\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\"\u0010&\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R'\u0010,\u001a\u0012\u0012\u0004\u0012\u00020'0\fj\b\u0012\u0004\u0012\u00020'`\u000e8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lii/a;", "Lq9/a;", "Lci/e;", "", "U1", "W1", "Lci/h;", "requestBean", "", "X1", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "albumInfo", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/StMedia;", "Lkotlin/collections/ArrayList;", "mediaList", "Lcom/tencent/qqnt/kernel/nativeinterface/MediaListInfo;", "mediaListInfo", "T1", "", "D", "Ljava/lang/String;", "P1", "()Ljava/lang/String;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(Ljava/lang/String;)V", "groupId", "E", "O1", "Z1", "batchId", UserInfo.SEX_FEMALE, "Q1", "setLeftAttachInfo", "leftAttachInfo", "G", "R1", "b2", "rightAttachInfo", "", "H", "Ljava/util/ArrayList;", "S1", "()Ljava/util/ArrayList;", "rightList", "<init>", "()V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a extends q9.a<ci.e> {

    /* renamed from: D, reason: from kotlin metadata */
    private String groupId = "";

    /* renamed from: E, reason: from kotlin metadata */
    private String batchId = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String leftAttachInfo = "";

    /* renamed from: G, reason: from kotlin metadata */
    private String rightAttachInfo = "";

    /* renamed from: H, reason: from kotlin metadata */
    private final ArrayList<Integer> rightList = new ArrayList<>();

    /* renamed from: O1, reason: from getter */
    public final String getBatchId() {
        return this.batchId;
    }

    /* renamed from: P1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: Q1, reason: from getter */
    public final String getLeftAttachInfo() {
        return this.leftAttachInfo;
    }

    /* renamed from: R1, reason: from getter */
    public final String getRightAttachInfo() {
        return this.rightAttachInfo;
    }

    public final ArrayList<Integer> S1() {
        return this.rightList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void T1(h requestBean, AlbumInfo albumInfo, ArrayList<StMedia> mediaList, MediaListInfo mediaListInfo) {
        long coerceIn;
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(mediaListInfo, "mediaListInfo");
        getLoadInfo().setCurrentState(4);
        ci.e eVar = new ci.e();
        boolean z16 = mediaListInfo.prevHasMore;
        boolean z17 = mediaListInfo.nextHasMore;
        if (requestBean.getIsFetchRight()) {
            String str = mediaListInfo.nextAttachInfo;
            Intrinsics.checkNotNullExpressionValue(str, "mediaListInfo.nextAttachInfo");
            this.rightAttachInfo = str;
            eVar.u0(!z17);
        }
        if (requestBean.getIsFetchLeft()) {
            String str2 = mediaListInfo.prevAttachInfo;
            Intrinsics.checkNotNullExpressionValue(str2, "mediaListInfo.prevAttachInfo");
            this.leftAttachInfo = str2;
            eVar.r0(!z16);
        }
        eVar.t0(requestBean.getIsRefresh());
        eVar.o0(requestBean.getIsFetchLeft());
        eVar.p0(requestBean.getIsFetchRight());
        eVar.q0(mediaListInfo.mediasIndex);
        com.tencent.xaction.log.b.a("GroupAlbumBaseLayerDataViewModel", 1, "mediasIndex is " + mediaListInfo.mediasIndex);
        eVar.k(albumInfo.name);
        eVar.j(albumInfo.albumId);
        eVar.e0(this.groupId);
        eVar.b0(this.batchId);
        coerceIn = RangesKt___RangesKt.coerceIn(albumInfo.uploadNumber, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, TTL.MAX_VALUE);
        eVar.s0((int) coerceIn);
        ArrayList<CommonStMedia> arrayList = new ArrayList<>();
        Iterator<T> it = mediaList.iterator();
        while (it.hasNext()) {
            arrayList.add(xh.h.b((StMedia) it.next()));
        }
        eVar.y(arrayList);
        if (eVar.getMediumSum() == 0) {
            eVar.s0(eVar.g().size());
        }
        if (ArrayUtils.isOutOfArrayIndex(0, eVar.g())) {
            M1().postValue(UIStateData.obtainEmpty());
        } else {
            M1().postValue(UIStateData.obtainSuccess(false).setDataList(eVar));
        }
    }

    public boolean U1() {
        return this.rightList.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMDELETEALBUM.ordinal()));
    }

    public boolean W1() {
        return true;
    }

    public abstract void X1(h requestBean);

    public final void Z1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.batchId = str;
    }

    public final void a2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void b2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightAttachInfo = str;
    }
}
