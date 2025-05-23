package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020'0&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageHeadRsp;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCommonExt;", "ext", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCommonExt;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/MainPageControl;", "mainPageControl", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/MainPageControl;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/UserProfile;", "userProfile", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/UserProfile;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/CommCount;", "commCount", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/CommCount;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/FunnyTreadInfo;", "funntTreadInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/FunnyTreadInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/FamousInfo;", "famousInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/FamousInfo;", "", "isIOSAudiVersion", "Z", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/IntimateSpaceInfo;", "intimateSpaceInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/IntimateSpaceInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SpecialInfo;", "specialInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SpecialInfo;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCommonExt;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/MainPageControl;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/UserProfile;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/CommCount;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/FunnyTreadInfo;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/FamousInfo;ZLcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/IntimateSpaceInfo;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SpecialInfo;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GetMainPageHeadRsp extends j {
    public static final int $stable = 8;
    public CommCount commCount;
    public StCommonExt ext;
    public FamousInfo famousInfo;
    public FunnyTreadInfo funntTreadInfo;
    public IntimateSpaceInfo intimateSpaceInfo;
    public boolean isIOSAudiVersion;
    public MainPageControl mainPageControl;
    public SpecialInfo specialInfo;
    public UserProfile userProfile;

    public GetMainPageHeadRsp() {
        this(null, null, null, null, null, null, false, null, null, 511, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new GetMainPageHeadRsp(null, null, null, null, null, null, false, null, null, 511, null));
    }

    public /* synthetic */ GetMainPageHeadRsp(StCommonExt stCommonExt, MainPageControl mainPageControl, UserProfile userProfile, CommCount commCount, FunnyTreadInfo funnyTreadInfo, FamousInfo famousInfo, boolean z16, IntimateSpaceInfo intimateSpaceInfo, SpecialInfo specialInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : stCommonExt, (i3 & 2) != 0 ? null : mainPageControl, (i3 & 4) != 0 ? null : userProfile, (i3 & 8) != 0 ? null : commCount, (i3 & 16) != 0 ? null : funnyTreadInfo, (i3 & 32) != 0 ? null : famousInfo, (i3 & 64) != 0 ? false : z16, (i3 & 128) != 0 ? null : intimateSpaceInfo, (i3 & 256) == 0 ? specialInfo : null);
    }

    public GetMainPageHeadRsp(StCommonExt stCommonExt, MainPageControl mainPageControl, UserProfile userProfile, CommCount commCount, FunnyTreadInfo funnyTreadInfo, FamousInfo famousInfo, boolean z16, IntimateSpaceInfo intimateSpaceInfo, SpecialInfo specialInfo) {
        this.ext = stCommonExt;
        this.mainPageControl = mainPageControl;
        this.userProfile = userProfile;
        this.commCount = commCount;
        this.funntTreadInfo = funnyTreadInfo;
        this.famousInfo = famousInfo;
        this.isIOSAudiVersion = z16;
        this.intimateSpaceInfo = intimateSpaceInfo;
        this.specialInfo = specialInfo;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        int i3 = 3;
        boolean z16 = false;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.ext, new b.d(new StCommonExt(null, null, null, null, 15, null)))), TuplesKt.to(2, new h(2, this.mainPageControl, new b.d(new MainPageControl(0, 0 == true ? 1 : 0, false, 0 == true ? 1 : 0, null, null, 63, null)))), TuplesKt.to(3, new h(3, this.userProfile, new b.d(new UserProfile(null, null, 0 == true ? 1 : 0, 7, 0 == true ? 1 : 0)))), TuplesKt.to(4, new h(4, this.commCount, new b.d(new CommCount(0, 0, 0, 0, 0, 31, null)))), TuplesKt.to(5, new h(5, this.funntTreadInfo, new b.d(new FunnyTreadInfo(false, 0 == true ? 1 : 0, i3, null)))), TuplesKt.to(6, new h(6, this.famousInfo, new b.d(new FamousInfo(0L, 0L, false, 7, null)))), TuplesKt.to(7, new h(7, Boolean.valueOf(this.isIOSAudiVersion), new b.e.a(false))), TuplesKt.to(8, new h(8, this.intimateSpaceInfo, new b.d(new IntimateSpaceInfo(z16, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)))), TuplesKt.to(9, new h(9, this.specialInfo, new b.d(new SpecialInfo(z16, z16, i3, 0 == true ? 1 : 0)))));
        return mapOf;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt");
                this.ext = (StCommonExt) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.MainPageControl");
                this.mainPageControl = (MainPageControl) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.UserProfile");
                this.userProfile = (UserProfile) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.CommCount");
                this.commCount = (CommCount) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.FunnyTreadInfo");
                this.funntTreadInfo = (FunnyTreadInfo) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.FamousInfo");
                this.famousInfo = (FamousInfo) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.isIOSAudiVersion = ((Boolean) v3).booleanValue();
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.IntimateSpaceInfo");
                this.intimateSpaceInfo = (IntimateSpaceInfo) v3;
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.SpecialInfo");
                this.specialInfo = (SpecialInfo) v3;
                return;
            default:
                return;
        }
    }
}
