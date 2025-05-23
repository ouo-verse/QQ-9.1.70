package com.tencent.mobileqq.search.searchdetail.content.template.model;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchGuildJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchNineBoxContent;
import com.tencent.qqnt.kernel.nativeinterface.SearchNineBoxGrid;
import com.tencent.qqnt.kernel.nativeinterface.SearchPicture;
import com.tencent.qqnt.kernel.nativeinterface.SearchPictureDetail;
import com.tencent.qqnt.kernel.nativeinterface.SearchStFeed;
import com.tencent.qqnt.kernel.nativeinterface.SearchStVideo;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import com.tencent.qqnt.kernel.nativeinterface.SearchVideo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u008c\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u008d\u0001B\u001d\u0012\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001\u0012\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\u000b*\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0014\u001a\u0004\u0018\u00010\bJ\b\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0010\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0000H\u0016J\u0017\u0010#\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fH\u0016\u00a2\u0006\u0004\b#\u0010$J\b\u0010%\u001a\u00020\u0016H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u001dH\u0016J\u0013\u0010*\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010+\u001a\u00020\u0016H\u0016R\u0017\u0010/\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010,\u001a\u0004\b-\u0010.R.\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b0\u00102\"\u0004\b3\u00104R$\u0010<\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010E\u001a\n >*\u0004\u0018\u00010=0=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010L\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR*\u0010T\u001a\n >*\u0004\u0018\u00010M0M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001f\u0010V\u001a\n >*\u0004\u0018\u00010M0M8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010O\u001a\u0004\bU\u0010QR*\u0010Y\u001a\n >*\u0004\u0018\u000106068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u00107\u001a\u0004\bW\u00109\"\u0004\bX\u0010;R*\u0010\\\u001a\n >*\u0004\u0018\u00010M0M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010O\u001a\u0004\bZ\u0010Q\"\u0004\b[\u0010SR\u0016\u0010_\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R$\u0010e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\b]\u0010b\"\u0004\bc\u0010dR$\u0010k\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010o\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u00108\u001a\u0004\b`\u0010l\"\u0004\bm\u0010nR\"\u0010v\u001a\u00020p8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010{\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bw\u0010\u000e\u001a\u0004\b?\u0010x\"\u0004\by\u0010zR\"\u0010~\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b|\u0010\u000e\u001a\u0004\b}\u0010x\"\u0004\bw\u0010zR(\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b^\u0010\u007f\u001a\u0005\b\u0080\u0001\u0010\u0011\"\u0006\b\u0081\u0001\u0010\u0082\u0001R$\u0010\u0085\u0001\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0005\b\u0084\u0001\u0010\u000e\u001a\u0004\bN\u0010x\"\u0004\b|\u0010z\u00a8\u0006\u008e\u0001"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/n;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/u;", "Lcom/tencent/mobileqq/search/searchdetail/content/model/a;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "V", "", "U", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchNineBoxContent;", "y", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchNineBoxGrid;", "", "K", "", "I", "", "l", "()Ljava/lang/Long;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isPlayable", "", "newState", "", "f", "isPlaying", "Landroid/content/Context;", "context", "", "P", "Lcom/tencent/mobileqq/search/searchdetail/c;", "newItem", "b", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/mobileqq/search/searchdetail/c;)Ljava/lang/Boolean;", "getItemType", "i", "toString", "", "other", "equals", "hashCode", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchNineBoxGrid;", "M", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchNineBoxGrid;", "nineBoxGrid", "J", "Ljava/util/List;", "()Ljava/util/List;", "setMediaList", "(Ljava/util/List;)V", "mediaList", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", UserInfo.SEX_FEMALE, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "setContentTitle", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;)V", "contentTitle", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "kotlin.jvm.PlatformType", "L", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "getButton", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "setButton", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;)V", "button", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", "B", "()Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", "W", "(Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;)V", "buttonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "N", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "D", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "setContentIcon", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;)V", "contentIcon", BdhLogUtil.LogTag.Tag_Req, "titleTag", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, IECSearchBar.METHOD_SET_TEXT, "text", "G", "setDescribe", "describe", ExifInterface.LATITUDE_SOUTH, "Z", "isContainVideo", "T", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchNineBoxContent;", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchNineBoxContent;", "setVideoItem", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchNineBoxContent;)V", "videoItem", "Lfeedcloud/FeedCloudMeta$StFeed;", "O", "()Lfeedcloud/FeedCloudMeta$StFeed;", "setSingleVideoData", "(Lfeedcloud/FeedCloudMeta$StFeed;)V", "singleVideoData", "()F", "setVideoRatio", "(F)V", "videoRatio", "Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;", "Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;", "E", "()Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;", "setContentRichText", "(Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;)V", "contentRichText", "X", "()I", "setMoreCount", "(I)V", "moreCount", "Y", "getJoinState", "joinState", "Ljava/lang/Long;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setBtnGuildId", "(Ljava/lang/Long;)V", "btnGuildId", "a0", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "searchTemplate", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "b0", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.n, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchTemplateNineBoxGridItem extends QSearchBaseTitleGroupTemplateItem implements com.tencent.mobileqq.search.searchdetail.content.model.a, Cloneable {

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @NotNull
    private final SearchNineBoxGrid nineBoxGrid;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @NotNull
    private List<? extends List<SearchNineBoxContent>> mediaList;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    @Nullable
    private SearchText contentTitle;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    private SearchButton button;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private k buttonInfo;

    /* renamed from: N, reason: from kotlin metadata and from toString */
    private SearchIcon contentIcon;

    /* renamed from: P, reason: from kotlin metadata */
    private final SearchIcon titleTag;

    /* renamed from: Q, reason: from kotlin metadata and from toString */
    private SearchText text;

    /* renamed from: R, reason: from kotlin metadata and from toString */
    private SearchIcon describe;

    /* renamed from: S, reason: from kotlin metadata and from toString */
    private boolean isContainVideo;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private SearchNineBoxContent videoItem;

    /* renamed from: U, reason: from kotlin metadata and from toString */
    @Nullable
    private FeedCloudMeta$StFeed singleVideoData;

    /* renamed from: V, reason: from kotlin metadata and from toString */
    private float videoRatio;

    /* renamed from: W, reason: from kotlin metadata and from toString */
    @NotNull
    private com.tencent.mobileqq.search.searchdetail.multimedia.q contentRichText;

    /* renamed from: X, reason: from kotlin metadata and from toString */
    private int moreCount;

    /* renamed from: Y, reason: from kotlin metadata and from toString */
    private int joinState;

    /* renamed from: Z, reason: from kotlin metadata and from toString */
    @Nullable
    private Long guildId;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata and from toString */
    private int playState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NetSearchTemplateNineBoxGridItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate searchTemplate) {
        super(commonInfo, searchTemplate);
        int i3;
        int i16;
        SearchJump searchJump;
        SearchPictureDetail searchPictureDetail;
        SearchPicture searchPicture;
        SearchPictureDetail searchPictureDetail2;
        SearchPicture searchPicture2;
        SearchJump searchJump2;
        SearchPictureDetail searchPictureDetail3;
        SearchPicture searchPicture3;
        SearchPictureDetail searchPictureDetail4;
        SearchPicture searchPicture4;
        SearchJump searchJump3;
        SearchText searchText;
        String str;
        String replace;
        ArrayList<SearchNineBoxContent> arrayList;
        int i17;
        SearchJump H;
        int i18;
        SearchJump H2;
        SearchGuildJump searchGuildJump;
        SearchGuildJump searchGuildJump2;
        int i19;
        SearchVideo searchVideo;
        SearchVideo searchVideo2;
        SearchJump searchJump4;
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(searchTemplate, "searchTemplate");
        SearchNineBoxGrid searchNineBoxGrid = searchTemplate.nineBoxGrid;
        searchNineBoxGrid = searchNineBoxGrid == null ? new SearchNineBoxGrid() : searchNineBoxGrid;
        this.nineBoxGrid = searchNineBoxGrid;
        Long l3 = null;
        if (I()) {
            SearchNineBoxContent y16 = y();
            if (y16 != null && (searchVideo2 = y16.video) != null && (searchJump4 = searchVideo2.jumpLink) != null) {
                i19 = searchJump4.type;
            } else {
                i19 = 0;
            }
            if (i19 > 0) {
                SearchNineBoxContent y17 = y();
                if (y17 != null && (searchVideo = y17.video) != null) {
                    searchJump = searchVideo.jumpLink;
                    w(searchJump);
                    this.mediaList = K(searchNineBoxGrid);
                    this.contentTitle = searchNineBoxGrid.title;
                    SearchButton searchButton = searchNineBoxGrid.button;
                    this.button = searchButton;
                    this.buttonInfo = k.INSTANCE.a(searchButton);
                    this.contentIcon = searchNineBoxGrid.icon;
                    this.titleTag = searchNineBoxGrid.tag;
                    this.text = searchNineBoxGrid.text;
                    this.describe = searchNineBoxGrid.describe;
                    this.isContainVideo = I();
                    this.videoItem = y();
                    this.singleVideoData = V();
                    this.videoRatio = U();
                    com.tencent.mobileqq.search.searchdetail.multimedia.q qVar = new com.tencent.mobileqq.search.searchdetail.multimedia.q(searchNineBoxGrid.richText);
                    searchText = searchNineBoxGrid.text;
                    if (searchText != null) {
                        str = searchText.text;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str, "nineBoxGrid.text?.text ?: \"\"");
                    }
                    replace = StringsKt__StringsJVMKt.replace(str, "\n", "", true);
                    qVar.e(replace);
                    this.contentRichText = qVar;
                    arrayList = searchNineBoxGrid.contentList;
                    if (arrayList != null) {
                        i17 = arrayList.size();
                    } else {
                        i17 = 0;
                    }
                    this.moreCount = Math.max(i17 - 3, 0);
                    H = H();
                    if (H == null && (searchGuildJump2 = H.guildJump) != null) {
                        i18 = searchGuildJump2.joinStatus;
                    } else {
                        i18 = 2;
                    }
                    this.joinState = i18;
                    H2 = H();
                    if (H2 != null && (searchGuildJump = H2.guildJump) != null) {
                        l3 = Long.valueOf(searchGuildJump.guildId);
                    }
                    this.guildId = l3;
                }
                searchJump = null;
                w(searchJump);
                this.mediaList = K(searchNineBoxGrid);
                this.contentTitle = searchNineBoxGrid.title;
                SearchButton searchButton2 = searchNineBoxGrid.button;
                this.button = searchButton2;
                this.buttonInfo = k.INSTANCE.a(searchButton2);
                this.contentIcon = searchNineBoxGrid.icon;
                this.titleTag = searchNineBoxGrid.tag;
                this.text = searchNineBoxGrid.text;
                this.describe = searchNineBoxGrid.describe;
                this.isContainVideo = I();
                this.videoItem = y();
                this.singleVideoData = V();
                this.videoRatio = U();
                com.tencent.mobileqq.search.searchdetail.multimedia.q qVar2 = new com.tencent.mobileqq.search.searchdetail.multimedia.q(searchNineBoxGrid.richText);
                searchText = searchNineBoxGrid.text;
                if (searchText != null) {
                }
                if (str == null) {
                }
                replace = StringsKt__StringsJVMKt.replace(str, "\n", "", true);
                qVar2.e(replace);
                this.contentRichText = qVar2;
                arrayList = searchNineBoxGrid.contentList;
                if (arrayList != null) {
                }
                this.moreCount = Math.max(i17 - 3, 0);
                H = H();
                if (H == null) {
                }
                i18 = 2;
                this.joinState = i18;
                H2 = H();
                if (H2 != null) {
                    l3 = Long.valueOf(searchGuildJump.guildId);
                }
                this.guildId = l3;
            }
        }
        SearchNineBoxContent z16 = z();
        if (z16 != null && (searchPictureDetail4 = z16.picture) != null && (searchPicture4 = searchPictureDetail4.large) != null && (searchJump3 = searchPicture4.jumpLink) != null) {
            i3 = searchJump3.type;
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            SearchNineBoxContent z17 = z();
            if (z17 != null && (searchPictureDetail3 = z17.picture) != null && (searchPicture3 = searchPictureDetail3.large) != null) {
                searchJump = searchPicture3.jumpLink;
            }
            searchJump = null;
        } else {
            SearchNineBoxContent z18 = z();
            if (z18 != null && (searchPictureDetail2 = z18.picture) != null && (searchPicture2 = searchPictureDetail2.small) != null && (searchJump2 = searchPicture2.jumpLink) != null) {
                i16 = searchJump2.type;
            } else {
                i16 = 0;
            }
            if (i16 > 0) {
                SearchNineBoxContent z19 = z();
                if (z19 != null && (searchPictureDetail = z19.picture) != null && (searchPicture = searchPictureDetail.small) != null) {
                    searchJump = searchPicture.jumpLink;
                }
                searchJump = null;
            } else {
                searchJump = searchTemplate.jumpLink;
            }
        }
        w(searchJump);
        this.mediaList = K(searchNineBoxGrid);
        this.contentTitle = searchNineBoxGrid.title;
        SearchButton searchButton22 = searchNineBoxGrid.button;
        this.button = searchButton22;
        this.buttonInfo = k.INSTANCE.a(searchButton22);
        this.contentIcon = searchNineBoxGrid.icon;
        this.titleTag = searchNineBoxGrid.tag;
        this.text = searchNineBoxGrid.text;
        this.describe = searchNineBoxGrid.describe;
        this.isContainVideo = I();
        this.videoItem = y();
        this.singleVideoData = V();
        this.videoRatio = U();
        com.tencent.mobileqq.search.searchdetail.multimedia.q qVar22 = new com.tencent.mobileqq.search.searchdetail.multimedia.q(searchNineBoxGrid.richText);
        searchText = searchNineBoxGrid.text;
        if (searchText != null) {
        }
        if (str == null) {
        }
        replace = StringsKt__StringsJVMKt.replace(str, "\n", "", true);
        qVar22.e(replace);
        this.contentRichText = qVar22;
        arrayList = searchNineBoxGrid.contentList;
        if (arrayList != null) {
        }
        this.moreCount = Math.max(i17 - 3, 0);
        H = H();
        if (H == null) {
        }
        i18 = 2;
        this.joinState = i18;
        H2 = H();
        if (H2 != null) {
        }
        this.guildId = l3;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean I() {
        boolean z16;
        boolean z17;
        Object firstOrNull;
        if (this.nineBoxGrid.getNineBoxGridType() == 1) {
            ArrayList<SearchNineBoxContent> arrayList = this.nineBoxGrid.contentList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "nineBoxGrid.contentList");
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (((SearchNineBoxContent) it.next()).type == 2) {
                    return true;
                }
            }
        }
        ArrayList<SearchNineBoxContent> arrayList2 = this.nineBoxGrid.contentList;
        if (arrayList2 != null && arrayList2.size() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ArrayList<SearchNineBoxContent> arrayList3 = this.nineBoxGrid.contentList;
            if (arrayList3 != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList3);
                SearchNineBoxContent searchNineBoxContent = (SearchNineBoxContent) firstOrNull;
                if (searchNineBoxContent != null && searchNineBoxContent.type == 2) {
                    z17 = true;
                    if (z17) {
                        return true;
                    }
                }
            }
            z17 = false;
            if (z17) {
            }
        }
        return false;
    }

    private final List<List<SearchNineBoxContent>> K(SearchNineBoxGrid searchNineBoxGrid) {
        boolean z16;
        List<List<SearchNineBoxContent>> emptyList;
        ArrayList<SearchNineBoxContent> arrayList = searchNineBoxGrid.contentList;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = (searchNineBoxGrid.contentList.size() - 1) / 3;
        if (size >= 0) {
            int i3 = 0;
            while (true) {
                arrayList2.add(new ArrayList());
                if (i3 == size) {
                    break;
                }
                i3++;
            }
        }
        int size2 = searchNineBoxGrid.contentList.size();
        for (int i16 = 0; i16 < size2; i16++) {
            ((ArrayList) arrayList2.get(i16 / 3)).add(searchNineBoxGrid.contentList.get(i16));
        }
        return arrayList2;
    }

    private final float U() {
        int i3;
        String str;
        SearchVideo searchVideo;
        SearchStFeed searchStFeed;
        SearchStVideo searchStVideo;
        SearchVideo searchVideo2;
        SearchStFeed searchStFeed2;
        SearchStVideo searchStVideo2;
        if (!this.isContainVideo) {
            return 1.0f;
        }
        SearchNineBoxContent searchNineBoxContent = this.videoItem;
        int i16 = 0;
        if (searchNineBoxContent != null && (searchVideo2 = searchNineBoxContent.video) != null && (searchStFeed2 = searchVideo2.feed) != null && (searchStVideo2 = searchStFeed2.video) != null) {
            i3 = searchStVideo2.width;
        } else {
            i3 = 0;
        }
        if (searchNineBoxContent != null && (searchVideo = searchNineBoxContent.video) != null && (searchStFeed = searchVideo.feed) != null && (searchStVideo = searchStFeed.video) != null) {
            i16 = searchStVideo.height;
        }
        if (i3 > 0 && i16 > 0) {
            return i3 / i16;
        }
        CommonInfo commonInfo = getCommonInfo();
        if (commonInfo != null) {
            str = commonInfo.getItemId();
        } else {
            str = null;
        }
        QLog.i("NetSearchTemplateNineBoxGridItem", 2, "getVideoRatioByData error for " + i3 + "," + i16 + ",itemId:" + str);
        return 1.0f;
    }

    private final FeedCloudMeta$StFeed V() {
        SearchNineBoxContent searchNineBoxContent;
        SearchVideo searchVideo;
        byte[] bArr;
        if (!this.isContainVideo || (searchNineBoxContent = this.videoItem) == null || (searchVideo = searchNineBoxContent.video) == null || (bArr = searchVideo.rawData) == null) {
            return null;
        }
        try {
            return (FeedCloudMeta$StFeed) MessageMicro.mergeFrom(new FeedCloudMeta$StFeed(), bArr);
        } catch (Throwable th5) {
            QLog.e("NetSearchTemplateNineBoxGridItem", 1, "singleVideoData parse failed", th5);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        if (r0.type == 2) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SearchNineBoxContent y() {
        boolean z16;
        Object firstOrNull;
        boolean z17 = true;
        if (this.nineBoxGrid.getNineBoxGridType() == 1) {
            ArrayList<SearchNineBoxContent> arrayList = this.nineBoxGrid.contentList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "nineBoxGrid.contentList");
            for (SearchNineBoxContent searchNineBoxContent : arrayList) {
                if (searchNineBoxContent.type == 2) {
                    return searchNineBoxContent;
                }
            }
        }
        ArrayList<SearchNineBoxContent> arrayList2 = this.nineBoxGrid.contentList;
        if (arrayList2 != null && arrayList2.size() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ArrayList<SearchNineBoxContent> arrayList3 = this.nineBoxGrid.contentList;
            if (arrayList3 != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList3);
                SearchNineBoxContent searchNineBoxContent2 = (SearchNineBoxContent) firstOrNull;
                if (searchNineBoxContent2 != null) {
                }
            }
            z17 = false;
            if (z17) {
                return z();
            }
            return null;
        }
        return null;
    }

    @Nullable
    /* renamed from: A, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    @Nullable
    /* renamed from: B, reason: from getter */
    public final k getButtonInfo() {
        return this.buttonInfo;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a, com.tencent.mobileqq.search.searchdetail.c
    @NotNull
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Boolean e(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Boolean.valueOf(!a(newItem));
    }

    /* renamed from: D, reason: from getter */
    public final SearchIcon getContentIcon() {
        return this.contentIcon;
    }

    @NotNull
    /* renamed from: E, reason: from getter */
    public final com.tencent.mobileqq.search.searchdetail.multimedia.q getContentRichText() {
        return this.contentRichText;
    }

    @Nullable
    /* renamed from: F, reason: from getter */
    public final SearchText getContentTitle() {
        return this.contentTitle;
    }

    /* renamed from: G, reason: from getter */
    public final SearchIcon getDescribe() {
        return this.describe;
    }

    @Nullable
    public final SearchJump H() {
        SearchButton searchButton = this.nineBoxGrid.button;
        if (searchButton != null) {
            return searchButton.jumpLink;
        }
        return null;
    }

    @NotNull
    public final List<List<SearchNineBoxContent>> J() {
        return this.mediaList;
    }

    /* renamed from: L, reason: from getter */
    public final int getMoreCount() {
        return this.moreCount;
    }

    @NotNull
    /* renamed from: M, reason: from getter */
    public final SearchNineBoxGrid getNineBoxGrid() {
        return this.nineBoxGrid;
    }

    /* renamed from: N, reason: from getter */
    public final int getPlayState() {
        return this.playState;
    }

    @Nullable
    /* renamed from: O, reason: from getter */
    public final FeedCloudMeta$StFeed getSingleVideoData() {
        return this.singleVideoData;
    }

    @NotNull
    public final String P(@NotNull Context context) {
        String str;
        boolean z16;
        long j3;
        SearchText searchText;
        Intrinsics.checkNotNullParameter(context, "context");
        SearchIcon searchIcon = this.contentIcon;
        if (searchIcon != null && (searchText = searchIcon.subTitle) != null) {
            str = searchText.text;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return str;
        }
        SearchIcon searchIcon2 = this.contentIcon;
        if (searchIcon2 != null) {
            j3 = searchIcon2.timestamp;
        } else {
            j3 = 0;
        }
        if (j3 == 0) {
            return "";
        }
        return com.tencent.mobileqq.search.searchdetail.multimedia.o.f284545a.b(System.currentTimeMillis(), j3 * 1000, context);
    }

    /* renamed from: Q, reason: from getter */
    public final SearchText getText() {
        return this.text;
    }

    /* renamed from: R, reason: from getter */
    public final SearchIcon getTitleTag() {
        return this.titleTag;
    }

    @Nullable
    /* renamed from: S, reason: from getter */
    public final SearchNineBoxContent getVideoItem() {
        return this.videoItem;
    }

    /* renamed from: T, reason: from getter */
    public final float getVideoRatio() {
        return this.videoRatio;
    }

    public final void W(@Nullable k kVar) {
        this.buttonInfo = kVar;
    }

    public final void X(int i3) {
        this.joinState = i3;
    }

    public final void Y(int i3) {
        this.playState = i3;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a, com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public boolean b(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((newItem instanceof NetSearchTemplateNineBoxGridItem) && super.b(newItem)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public boolean equals(@Nullable Object other) {
        boolean z16;
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetSearchTemplateNineBoxGridItem) || !super.equals(other)) {
            return false;
        }
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem = (NetSearchTemplateNineBoxGridItem) other;
        if (!Intrinsics.areEqual(this.nineBoxGrid, netSearchTemplateNineBoxGridItem.nineBoxGrid) || !Intrinsics.areEqual(this.mediaList, netSearchTemplateNineBoxGridItem.mediaList) || !Intrinsics.areEqual(this.contentTitle, netSearchTemplateNineBoxGridItem.contentTitle) || !Intrinsics.areEqual(this.button, netSearchTemplateNineBoxGridItem.button) || !Intrinsics.areEqual(this.buttonInfo, netSearchTemplateNineBoxGridItem.buttonInfo) || !Intrinsics.areEqual(this.contentIcon, netSearchTemplateNineBoxGridItem.contentIcon) || !Intrinsics.areEqual(this.titleTag, netSearchTemplateNineBoxGridItem.titleTag) || !Intrinsics.areEqual(this.text, netSearchTemplateNineBoxGridItem.text) || !Intrinsics.areEqual(this.describe, netSearchTemplateNineBoxGridItem.describe) || this.isContainVideo != netSearchTemplateNineBoxGridItem.isContainVideo || !Intrinsics.areEqual(this.videoItem, netSearchTemplateNineBoxGridItem.videoItem) || !Intrinsics.areEqual(this.singleVideoData, netSearchTemplateNineBoxGridItem.singleVideoData)) {
            return false;
        }
        if (this.videoRatio == netSearchTemplateNineBoxGridItem.videoRatio) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && Intrinsics.areEqual(this.contentRichText, netSearchTemplateNineBoxGridItem.contentRichText) && this.moreCount == netSearchTemplateNineBoxGridItem.moreCount && this.joinState == netSearchTemplateNineBoxGridItem.joinState && Intrinsics.areEqual(this.guildId, netSearchTemplateNineBoxGridItem.guildId) && this.playState == netSearchTemplateNineBoxGridItem.playState) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.model.a
    public void f(int newState) {
        this.playState = newState;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 6;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int hashCode = ((((super.hashCode() * 31) + this.nineBoxGrid.hashCode()) * 31) + this.mediaList.hashCode()) * 31;
        SearchText searchText = this.contentTitle;
        int i36 = 0;
        if (searchText != null) {
            i3 = searchText.hashCode();
        } else {
            i3 = 0;
        }
        int i37 = (hashCode + i3) * 31;
        SearchButton searchButton = this.button;
        if (searchButton != null) {
            i16 = searchButton.hashCode();
        } else {
            i16 = 0;
        }
        int i38 = (i37 + i16) * 31;
        k kVar = this.buttonInfo;
        if (kVar != null) {
            i17 = kVar.hashCode();
        } else {
            i17 = 0;
        }
        int i39 = (i38 + i17) * 31;
        SearchIcon searchIcon = this.contentIcon;
        if (searchIcon != null) {
            i18 = searchIcon.hashCode();
        } else {
            i18 = 0;
        }
        int i46 = (i39 + i18) * 31;
        SearchIcon searchIcon2 = this.titleTag;
        if (searchIcon2 != null) {
            i19 = searchIcon2.hashCode();
        } else {
            i19 = 0;
        }
        int i47 = (i46 + i19) * 31;
        SearchText searchText2 = this.text;
        if (searchText2 != null) {
            i26 = searchText2.hashCode();
        } else {
            i26 = 0;
        }
        int i48 = (i47 + i26) * 31;
        SearchIcon searchIcon3 = this.describe;
        if (searchIcon3 != null) {
            i27 = searchIcon3.hashCode();
        } else {
            i27 = 0;
        }
        int a16 = (((i48 + i27) * 31) + com.tencent.aio.widget.textView.param.a.a(this.isContainVideo)) * 31;
        SearchNineBoxContent searchNineBoxContent = this.videoItem;
        if (searchNineBoxContent != null) {
            i28 = searchNineBoxContent.hashCode();
        } else {
            i28 = 0;
        }
        int i49 = (a16 + i28) * 31;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.singleVideoData;
        if (feedCloudMeta$StFeed != null) {
            i29 = feedCloudMeta$StFeed.hashCode();
        } else {
            i29 = 0;
        }
        int floatToIntBits = (((((((((i49 + i29) * 31) + Float.floatToIntBits(this.videoRatio)) * 31) + this.contentRichText.hashCode()) * 31) + this.moreCount) * 31) + this.joinState) * 31;
        Long l3 = this.guildId;
        if (l3 != null) {
            i36 = l3.hashCode();
        }
        return ((floatToIntBits + i36) * 31) + this.playState;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public void i() {
        Object firstOrNull;
        SearchNineBoxContent searchNineBoxContent;
        String str;
        Object orNull;
        SearchNineBoxContent searchNineBoxContent2;
        String str2;
        String str3;
        SearchPicture searchPicture;
        SearchPicture searchPicture2;
        Object orNull2;
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        String str4;
        boolean z16;
        PBStringField pBStringField;
        String str5;
        SearchPictureDetail searchPictureDetail;
        SearchPicture searchPicture3;
        Object firstOrNull2;
        if (this.mediaList.size() == 1) {
            boolean z17 = false;
            if (this.mediaList.get(0).size() == 1) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.mediaList);
                List list = (List) firstOrNull;
                if (list != null) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                    searchNineBoxContent = (SearchNineBoxContent) firstOrNull2;
                } else {
                    searchNineBoxContent = null;
                }
                if (searchNineBoxContent != null && (searchPictureDetail = searchNineBoxContent.picture) != null && (searchPicture3 = searchPictureDetail.large) != null) {
                    str = searchPicture3.picLink;
                } else {
                    str = null;
                }
                if (getIsContainVideo()) {
                    FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.singleVideoData;
                    if (feedCloudMeta$StFeed != null) {
                        feedCloudMeta$StImage = feedCloudMeta$StFeed.cover;
                    } else {
                        feedCloudMeta$StImage = null;
                    }
                    if (feedCloudMeta$StImage == null) {
                        return;
                    }
                    PBStringField pBStringField2 = feedCloudMeta$StImage.picUrl;
                    if (pBStringField2 != null) {
                        str4 = pBStringField2.get();
                    } else {
                        str4 = null;
                    }
                    if (str4 != null && str4.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16 ? (pBStringField = feedCloudMeta$StImage.picUrl) != null : (pBStringField = feedCloudMeta$StImage.layerPicUrl) != null) {
                        str5 = pBStringField.get();
                    } else {
                        str5 = null;
                    }
                    if (str5 != null) {
                        com.tencent.mobileqq.search.searchdetail.util.c.b(com.tencent.mobileqq.search.searchdetail.util.c.f284739a, str5, 0, 0, 6, null);
                    }
                }
                if (str == null || str.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    com.tencent.mobileqq.search.searchdetail.util.c.b(com.tencent.mobileqq.search.searchdetail.util.c.f284739a, str, 0, 0, 6, null);
                    return;
                }
                for (int i3 = 1; i3 < 4; i3++) {
                    for (int i16 = 1; i16 < 4; i16++) {
                        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mediaList, i3);
                        List list2 = (List) orNull;
                        if (list2 != null) {
                            orNull2 = CollectionsKt___CollectionsKt.getOrNull(list2, i16);
                            searchNineBoxContent2 = (SearchNineBoxContent) orNull2;
                        } else {
                            searchNineBoxContent2 = null;
                        }
                        if (searchNineBoxContent2 != null) {
                            SearchPictureDetail searchPictureDetail2 = searchNineBoxContent2.picture;
                            if (searchPictureDetail2 != null && (searchPicture2 = searchPictureDetail2.small) != null) {
                                str2 = searchPicture2.picLink;
                            } else {
                                str2 = null;
                            }
                            if (str2 != null) {
                                com.tencent.mobileqq.search.searchdetail.util.c cVar = com.tencent.mobileqq.search.searchdetail.util.c.f284739a;
                                if (searchPictureDetail2 != null && (searchPicture = searchPictureDetail2.small) != null) {
                                    str3 = searchPicture.picLink;
                                } else {
                                    str3 = null;
                                }
                                if (str3 == null) {
                                    str3 = "";
                                }
                                com.tencent.mobileqq.search.searchdetail.util.c.b(cVar, str3, 0, 0, 6, null);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.model.a
    /* renamed from: isPlayable, reason: from getter */
    public boolean getIsContainVideo() {
        return this.isContainVideo;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.model.a
    public boolean isPlaying() {
        if (this.playState == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a, com.tencent.mobileqq.search.searchdetail.a
    @Nullable
    public Long l() {
        SearchGuildJump searchGuildJump;
        SearchJump searchJump = this.contentIcon.jumpLink;
        if (searchJump != null && (searchGuildJump = searchJump.guildJump) != null) {
            return Long.valueOf(searchGuildJump.guildId);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchBaseTitleGroupTemplateItem
    @NotNull
    public String toString() {
        return "NetSearchTemplateNineBoxGridItem(nineBoxGrid=" + this.nineBoxGrid + ", mediaList=" + this.mediaList + ", contentTitle=" + this.contentTitle + ", button=" + this.button + ", contentIcon=" + this.contentIcon + ", text=" + this.text + ", describe=" + this.describe + ", isContainVideo=" + this.isContainVideo + ", singleVideoData=" + this.singleVideoData + ", videoRatio=" + this.videoRatio + ", contentRichText=" + this.contentRichText + ", moreCount=" + this.moreCount + ", joinState=" + this.joinState + ", guildId=" + this.guildId + ", playState=" + this.playState + ") " + super.toString();
    }

    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public NetSearchTemplateNineBoxGridItem clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateNineBoxGridItem");
        return (NetSearchTemplateNineBoxGridItem) clone;
    }

    @Nullable
    public final SearchNineBoxContent z() {
        Object firstOrNull;
        ArrayList<SearchNineBoxContent> arrayList = this.nineBoxGrid.contentList;
        if (arrayList != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            return (SearchNineBoxContent) firstOrNull;
        }
        return null;
    }
}
