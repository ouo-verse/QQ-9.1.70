package com.qzone.reborn.groupalbum.viewmodel;

import android.content.Intent;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.base.n;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.util.ToastUtil;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMediaListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunCommentCallback;
import com.tencent.qqnt.kernel.nativeinterface.MediaListInfo;
import com.tencent.qqnt.kernel.nativeinterface.NTGetMediaListRsp;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunCommentReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunCommentRsp;
import com.tencent.qqnt.kernel.nativeinterface.QunMediaRightEnum;
import com.tencent.qqnt.kernel.nativeinterface.RequestTimelineInfo;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 \u0091\u00012\u00020\u0001:\u0004\u0092\u0001\u0093\u0001B\t\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J(\u0010 \u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\rH\u0002J \u0010!\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0016H\u0002J@\u0010+\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\r2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'2\u0006\u0010*\u001a\u00020)H\u0002J&\u0010/\u001a\u00020\u00042\u001c\u0010.\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020-0%j\b\u0012\u0004\u0012\u00020-`'0,H\u0002J\b\u00100\u001a\u00020\u0004H\u0002J\u0006\u00101\u001a\u00020\u0006J\u0006\u00102\u001a\u00020\rJ\u0006\u00103\u001a\u00020\u0016J\b\u00104\u001a\u00020\rH\u0016J\u000e\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u000205J\u0006\u00108\u001a\u00020\u0004J\u0018\u0010;\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u00022\u0006\u0010:\u001a\u00020\u0006J \u0010=\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u00022\u0006\u0010:\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0006J\b\u0010>\u001a\u0004\u0018\u00010\u0002J\u0006\u0010?\u001a\u00020\u0006J\u0006\u0010@\u001a\u00020\u0004J\u000e\u0010A\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006JR\u0010C\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010B\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\rH\u0004J\u000e\u0010F\u001a\u00020\u00042\u0006\u0010E\u001a\u00020DJ\u000e\u0010G\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006R\u0016\u0010J\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010B\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010P\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010LR\u0016\u0010R\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010LR\u0016\u0010T\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010LR\u0016\u0010V\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010IR\u0016\u0010Y\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR.\u0010`\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020,0Z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010h\u001a\u00020a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010o\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR&\u0010r\u001a\u0012\u0012\u0004\u0012\u00020-0%j\b\u0012\u0004\u0012\u00020-`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR3\u0010u\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020-0%j\b\u0012\u0004\u0012\u00020-`'0,0Z8\u0006\u00a2\u0006\f\n\u0004\bs\u0010[\u001a\u0004\bt\u0010]R\u001a\u0010y\u001a\u00020\u00168\u0004X\u0084D\u00a2\u0006\f\n\u0004\bv\u0010X\u001a\u0004\bw\u0010xR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\u007f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010bR(\u0010\u0081\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00160%j\b\u0012\u0004\u0012\u00020\u0016`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010qR(\u0010\u0087\u0001\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0082\u0001\u0010L\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R(\u0010\u008b\u0001\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0088\u0001\u0010L\u001a\u0006\b\u0089\u0001\u0010\u0084\u0001\"\u0006\b\u008a\u0001\u0010\u0086\u0001R\u0014\u0010\u008e\u0001\u001a\u00020\u00068F\u00a2\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\u00a8\u0006\u0094\u0001"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "", "v2", "", "X1", "e2", "requestSuccess", ICustomDataEditor.STRING_ARRAY_PARAM_2, "feedData", "b2", "", "msg", "", "retCode", ICustomDataEditor.STRING_PARAM_2, "", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "commentList", "L2", "", "totalCommentNum", "M2", "c2", "feedAttachInfo", "hasMore", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "I2", "attachInfo", Constants.BASE_IN_PLUGIN_VERSION, "l2", "m2", "failMsgResId", "H2", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/StMedia;", "Lkotlin/collections/ArrayList;", "mediaList", "Lcom/tencent/qqnt/kernel/nativeinterface/MediaListInfo;", "mediaInfo", "k2", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "picList", "w2", "C2", "p2", "f2", "getScene", "getLogTag", "Landroid/content/Intent;", "intent", "u2", "Z1", "businessDetailData", "fromCache", "J2", "isRefresh", "K2", "d2", "o2", "r2", "y2", "groupId", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "initBean", Constants.MMCCID, "z2", "i", "Z", "fromArk", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "mFeedId", BdhLogUtil.LogTag.Tag_Conn, "D", "albumId", "E", "batchId", UserInfo.SEX_FEMALE, "llocId", "G", "firstTimeRefresh", "H", "I", "fromEntry", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "i2", "()Landroidx/lifecycle/MutableLiveData;", "setMFeedDetailData", "(Landroidx/lifecycle/MutableLiveData;)V", "mFeedDetailData", "Lki/n;", "J", "Lki/n;", "getMFeedDetailRepo", "()Lki/n;", "setMFeedDetailRepo", "(Lki/n;)V", "mFeedDetailRepo", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "K", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "mMediaListLoadInfo", "L", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "mAlbumDetailInitBean", "M", "Ljava/util/ArrayList;", "mBatchList", "N", "j2", "mPictureItemList", "P", "getPAGE_LIMIT", "()I", "PAGE_LIMIT", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel$a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel$a;", "commentResponse", BdhLogUtil.LogTag.Tag_Req, "pageStartTimeMs", ExifInterface.LATITUDE_SOUTH, "rightList", "T", "g2", "()Ljava/lang/String;", "setLocationCommentId", "(Ljava/lang/String;)V", "locationCommentId", "U", SemanticAttributes.DbSystemValues.H2, "setLocationReplyId", "locationReplyId", "q2", "()Z", "isFromArk", "<init>", "()V", "V", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumFeedDetailViewModel extends com.qzone.reborn.base.n {

    /* renamed from: H, reason: from kotlin metadata */
    private int fromEntry;

    /* renamed from: L, reason: from kotlin metadata */
    private GroupAlbumAlbumDetailInitBean mAlbumDetailInitBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean fromArk;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String mFeedId = "";

    /* renamed from: C, reason: from kotlin metadata */
    private String groupId = "";

    /* renamed from: D, reason: from kotlin metadata */
    private String albumId = "";

    /* renamed from: E, reason: from kotlin metadata */
    private String batchId = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String llocId = "";

    /* renamed from: G, reason: from kotlin metadata */
    private boolean firstTimeRefresh = true;

    /* renamed from: I, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<BusinessFeedData>> mFeedDetailData = new MutableLiveData<>();

    /* renamed from: J, reason: from kotlin metadata */
    private ki.n mFeedDetailRepo = new ki.n();

    /* renamed from: K, reason: from kotlin metadata */
    private LoadInfo mMediaListLoadInfo = new LoadInfo();

    /* renamed from: M, reason: from kotlin metadata */
    private ArrayList<PictureItem> mBatchList = new ArrayList<>();

    /* renamed from: N, reason: from kotlin metadata */
    private final MutableLiveData<UIStateData<ArrayList<PictureItem>>> mPictureItemList = new MutableLiveData<>();

    /* renamed from: P, reason: from kotlin metadata */
    private final int PAGE_LIMIT = 20;

    /* renamed from: Q, reason: from kotlin metadata */
    private a commentResponse = new a();

    /* renamed from: R, reason: from kotlin metadata */
    private long pageStartTimeMs = -1;

    /* renamed from: S, reason: from kotlin metadata */
    private ArrayList<Integer> rightList = new ArrayList<>();

    /* renamed from: T, reason: from kotlin metadata */
    private String locationCommentId = "";

    /* renamed from: U, reason: from kotlin metadata */
    private String locationReplyId = "";

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\u0005\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel$a;", "", "", "toString", "", "a", "Z", "b", "()Z", "e", "(Z)V", "hasMore", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "feedAttachInfo", "c", "f", "hasResponse", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean hasMore;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private String attachInfo;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean hasResponse;

        /* renamed from: a, reason: from getter */
        public final String getAttachInfo() {
            return this.attachInfo;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getHasMore() {
            return this.hasMore;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getHasResponse() {
            return this.hasResponse;
        }

        public final void d(String str) {
            this.attachInfo = str;
        }

        public final void e(boolean z16) {
            this.hasMore = z16;
        }

        public final void f(boolean z16) {
            this.hasResponse = z16;
        }

        public String toString() {
            return "CommentResponse{hasMore=" + this.hasMore + ", attachInfo='" + this.attachInfo + "', hasResponse='" + this.hasResponse + "'}";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel$c", "Lcom/qzone/reborn/base/n$a;", "Lfj/o;", "wrapper", "", "retCode", "", "attachInfo", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements n.a<fj.o> {
        c() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(fj.o wrapper, long retCode, String attachInfo, boolean isFinish) {
            Intrinsics.checkNotNullParameter(wrapper, "wrapper");
            Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
            GroupAlbumFeedDetailViewModel.this.rightList.clear();
            GroupAlbumFeedDetailViewModel.this.rightList.addAll(wrapper.b());
            GroupAlbumFeedDetailViewModel.this.I2(attachInfo, !isFinish, true);
            GroupAlbumFeedDetailViewModel.this.K2(wrapper.getBusinessData(), false, true);
            GroupAlbumFeedDetailViewModel.this.a2(true);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            RFWLog.d("GroupAlbumFeedDetailViewModel", RFWLog.USR, "request feed detail error, " + errorMsg);
            GroupAlbumFeedDetailViewModel.this.s2(errorMsg, errorCode);
            GroupAlbumFeedDetailViewModel.this.a2(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(long j3, final GroupAlbumFeedDetailViewModel this$0, final boolean z16, final NTGetMediaListRsp nTGetMediaListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = nTGetMediaListRsp.result;
        fj.v.a(i3 == 0, 4, i3, System.currentTimeMillis() - j3, nTGetMediaListRsp.traceId);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.t
            @Override // java.lang.Runnable
            public final void run() {
                GroupAlbumFeedDetailViewModel.B2(NTGetMediaListRsp.this, this$0, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B2(NTGetMediaListRsp nTGetMediaListRsp, GroupAlbumFeedDetailViewModel this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MediaListInfo mediaListInfo = new MediaListInfo(nTGetMediaListRsp.prevAttachInfo, nTGetMediaListRsp.nextAttachInfo, nTGetMediaListRsp.prevHasMore, nTGetMediaListRsp.nextHasMore, nTGetMediaListRsp.mediaIndex);
        int i3 = nTGetMediaListRsp.result;
        String str = nTGetMediaListRsp.errMs;
        Intrinsics.checkNotNullExpressionValue(str, "response.errMs");
        ArrayList<StMedia> arrayList = nTGetMediaListRsp.mediaList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "response.mediaList");
        this$0.k2(z16, i3, str, arrayList, mediaListInfo);
    }

    private final void C2() {
        LoadInfo loadInfo = new LoadInfo();
        this.mMediaListLoadInfo = loadInfo;
        loadInfo.setStringAttachInfo("");
        this.mMediaListLoadInfo.setFinish(false);
    }

    private final void D2(String attachInfo, final boolean isLoadMore) {
        RequestTimelineInfo requestTimelineInfo = new RequestTimelineInfo();
        requestTimelineInfo.requestInvokeTime = System.currentTimeMillis();
        StCommonExt stCommonExt = new StCommonExt();
        String str = this.groupId;
        String str2 = this.mFeedId;
        int i3 = this.PAGE_LIMIT;
        if (attachInfo == null) {
            attachInfo = "";
        }
        final NTGetQunCommentReq nTGetQunCommentReq = new NTGetQunCommentReq(0, requestTimelineInfo, stCommonExt, str, str2, i3, attachInfo, this.albumId, this.batchId, this.llocId);
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.getQunComment(nTGetQunCommentReq, new IAlbumServiceGetQunCommentCallback() { // from class: com.qzone.reborn.groupalbum.viewmodel.u
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunCommentCallback
                public final void onGetQunComment(NTGetQunCommentRsp nTGetQunCommentRsp) {
                    GroupAlbumFeedDetailViewModel.E2(GroupAlbumFeedDetailViewModel.this, isLoadMore, nTGetQunCommentReq, nTGetQunCommentRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(final GroupAlbumFeedDetailViewModel this$0, final boolean z16, final NTGetQunCommentReq request, final NTGetQunCommentRsp nTGetQunCommentRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.v
            @Override // java.lang.Runnable
            public final void run() {
                GroupAlbumFeedDetailViewModel.F2(GroupAlbumFeedDetailViewModel.this, nTGetQunCommentRsp, z16, request);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F2(GroupAlbumFeedDetailViewModel this$0, NTGetQunCommentRsp nTGetQunCommentRsp, boolean z16, NTGetQunCommentReq request) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        QLog.e(this$0.getTAG(), 1, "sendCommentListRequest seq: " + nTGetQunCommentRsp.seq + " | resultCode: " + nTGetQunCommentRsp.result + " | errMsg:" + nTGetQunCommentRsp.errMs + " | nextAttachInfo:" + nTGetQunCommentRsp.attachInfo + " | hasMore:" + nTGetQunCommentRsp.hasmore + " | isLoadMore:" + z16 + " | lloc id" + this$0.llocId + " | traceId " + nTGetQunCommentRsp.traceId);
        int i3 = nTGetQunCommentRsp.result;
        fj.v.a(i3 == 0, 5, i3, System.currentTimeMillis() - request.requestTimeLine.requestInvokeTime, nTGetQunCommentRsp.traceId);
        CellCommentInfo v3 = yh.b.v(nTGetQunCommentRsp.cellComment, nTGetQunCommentRsp.ext);
        int i16 = nTGetQunCommentRsp.result;
        String str = nTGetQunCommentRsp.errMs;
        String str2 = this$0.groupId;
        int i17 = nTGetQunCommentRsp.cellComment.num;
        ArrayList<Comment> arrayList = v3 != null ? v3.commments : null;
        boolean z17 = nTGetQunCommentRsp.hasmore;
        String str3 = nTGetQunCommentRsp.attachInfo;
        Intrinsics.checkNotNullExpressionValue(str3, "response.attachInfo");
        this$0.n2(i16, str, str2, i17, arrayList, z17, z16, str3);
    }

    private final void H2(int failMsgResId) {
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
            ToastUtil.o(R.string.f1338579, 4);
        } else {
            ToastUtil.o(failMsgResId, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I2(String feedAttachInfo, boolean hasMore, boolean isLoadMore) {
        if (!this.commentResponse.getHasResponse()) {
            a aVar = this.commentResponse;
            aVar.e(hasMore);
            aVar.d(feedAttachInfo);
            aVar.f(true);
            return;
        }
        if (isLoadMore) {
            a aVar2 = this.commentResponse;
            aVar2.e(hasMore);
            aVar2.d(feedAttachInfo);
            aVar2.f(true);
        }
    }

    private final void L2(List<Comment> commentList) {
        BusinessFeedData data;
        UIStateData<BusinessFeedData> value = this.mFeedDetailData.getValue();
        CellCommentInfo commentInfo = (value == null || (data = value.getData()) == null) ? null : data.getCommentInfo();
        if (commentInfo == null) {
            return;
        }
        commentInfo.commments = new ArrayList<>();
        if (commentList != null) {
            Iterator<T> it = commentList.iterator();
            while (it.hasNext()) {
                commentInfo.commments.add((Comment) it.next());
            }
        }
    }

    private final void M2(int totalCommentNum) {
        BusinessFeedData data;
        UIStateData<BusinessFeedData> value = this.mFeedDetailData.getValue();
        CellCommentInfo commentInfo = (value == null || (data = value.getData()) == null) ? null : data.getCommentInfo();
        if (commentInfo == null) {
            return;
        }
        if (totalCommentNum <= 0) {
            ArrayList<Comment> arrayList = commentInfo.commments;
            commentInfo.serverRspTotalCommentNum = arrayList != null ? arrayList.size() : 0;
        } else {
            commentInfo.serverRspTotalCommentNum = totalCommentNum;
        }
    }

    private final boolean X1() {
        return this.fromEntry == 18 || this.fromArk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(boolean requestSuccess) {
        if (this.pageStartTimeMs <= 0) {
            return;
        }
        if (requestSuccess) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long currentTimeMillis = System.currentTimeMillis() - this.pageStartTimeMs;
            linkedHashMap.put("view_load_time", Long.valueOf(currentTimeMillis));
            linkedHashMap.put("view_type", 1);
            linkedHashMap.put("entry_type", Integer.valueOf(this.fromArk ? 0 : 2));
            RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "[doInit] doReportGroupAlbumFeedDetailFirstFrameEvent:" + currentTimeMillis);
            fo.c.c("ev_qun_album_view_load_time", linkedHashMap);
        }
        this.pageStartTimeMs = -1L;
    }

    private final void b2(BusinessFeedData feedData) {
        if (this.firstTimeRefresh) {
            this.firstTimeRefresh = false;
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(feedData.cellLikeInfo.likeKey);
            ki.p.f412499a.b(this.groupId, arrayList);
        }
    }

    private final List<Comment> c2() {
        BusinessFeedData data;
        CellCommentInfo commentInfo;
        ArrayList<Comment> arrayList;
        UIStateData<BusinessFeedData> value = this.mFeedDetailData.getValue();
        if (value == null || (data = value.getData()) == null || (commentInfo = data.getCommentInfo()) == null || (arrayList = commentInfo.commments) == null) {
            return null;
        }
        return arrayList;
    }

    private final BusinessFeedData e2() {
        return (BusinessFeedData) com.qzone.reborn.feedx.util.m.a("extra_key_parcelable_feed_for_detail");
    }

    private final void k2(boolean isLoadMore, int retCode, String errMsg, ArrayList<StMedia> mediaList, MediaListInfo mediaInfo) {
        ArrayList<PictureItem> r16;
        this.mMediaListLoadInfo.setCurrentState(4);
        if (retCode != 0) {
            UIStateData<ArrayList<PictureItem>> loadMore = UIStateData.obtainError(errMsg).setRetCode(retCode).setLoadMore(isLoadMore);
            Intrinsics.checkNotNullExpressionValue(loadMore, "obtainError<ArrayList<Pi\u2026 .setLoadMore(isLoadMore)");
            w2(loadMore);
            H2(R.string.f133606k);
            QLog.e(getTAG(), 1, "getMediaList error:" + retCode + "  errorMsg:" + errMsg);
            return;
        }
        this.mMediaListLoadInfo.setStringAttachInfo(mediaInfo.nextAttachInfo);
        boolean z16 = mediaInfo.nextHasMore;
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.mAlbumDetailInitBean;
        if (groupAlbumAlbumDetailInitBean != null && (r16 = yh.b.r(mediaList, groupAlbumAlbumDetailInitBean.getAlbumId())) != null) {
            this.mBatchList.clear();
            this.mBatchList.addAll(r16);
        }
        UIStateData<ArrayList<PictureItem>> loadMore2 = UIStateData.obtainSuccess(false).setDataList(this.mBatchList).setFinish(!z16).setLoadMore(isLoadMore);
        Intrinsics.checkNotNullExpressionValue(loadMore2, "obtainSuccess<ArrayList<\u2026 .setLoadMore(isLoadMore)");
        w2(loadMore2);
    }

    private final void l2(List<Comment> commentList, boolean hasMore, String attachInfo) {
        List<Comment> c26 = c2();
        if (c26 != null) {
            QLog.d(getTAG(), 1, "getCommentSize:" + (commentList != null ? Integer.valueOf(commentList.size()) : null) + ", attachInfo:" + attachInfo + "hasMore\uff1a" + hasMore);
            if (commentList != null) {
                c26.addAll(commentList);
            }
        }
        UIStateData<BusinessFeedData> value = this.mFeedDetailData.getValue();
        J2(value != null ? value.getData() : null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s2(String msg2, long retCode) {
        this.mFeedDetailData.setValue(UIStateData.obtainError(msg2).setRetCode(retCode));
    }

    private final void v2(BusinessFeedData data) {
        if (this.fromEntry != 18 || data == null || bl.b(data.getCommentInfo().commments)) {
            return;
        }
        Comment comment = data.getCommentInfo().commments.get(0);
        String str = comment.commentid;
        Intrinsics.checkNotNullExpressionValue(str, "comment.commentid");
        this.locationCommentId = str;
        if (!bl.b(comment.replies)) {
            String str2 = comment.replies.get(0).replyId;
            Intrinsics.checkNotNullExpressionValue(str2, "comment.replies[0].replyId");
            this.locationReplyId = str2;
        }
        QLog.i("GroupAlbumFeedDetailViewModel", 1, "parseMsgCommentLocationId  | locationCommentId = " + this.locationCommentId + " | locationReplyId = " + this.locationReplyId + " | comment.content = " + comment.comment + " | data.commentInfo.commments.size = " + data.getCommentInfo().commments.size());
    }

    private final void w2(final UIStateData<ArrayList<PictureItem>> picList) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.w
            @Override // java.lang.Runnable
            public final void run() {
                GroupAlbumFeedDetailViewModel.x2(GroupAlbumFeedDetailViewModel.this, picList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x2(GroupAlbumFeedDetailViewModel this$0, UIStateData picList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(picList, "$picList");
        this$0.mPictureItemList.setValue(picList);
    }

    public final void G2(GroupAlbumAlbumDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.mAlbumDetailInitBean = initBean;
    }

    public final BusinessFeedData d2() {
        UIStateData<BusinessFeedData> value = this.mFeedDetailData.getValue();
        if (value != null) {
            return value.getData();
        }
        return null;
    }

    /* renamed from: f2, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: g2, reason: from getter */
    public final String getLocationCommentId() {
        return this.locationCommentId;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumFeedDetailViewModel";
    }

    public final int getScene() {
        String str = this.llocId;
        if (str == null || str.length() == 0) {
            return ki.j.INSTANCE.a();
        }
        return ki.j.INSTANCE.b();
    }

    /* renamed from: h2, reason: from getter */
    public final String getLocationReplyId() {
        return this.locationReplyId;
    }

    public final MutableLiveData<UIStateData<BusinessFeedData>> i2() {
        return this.mFeedDetailData;
    }

    public final MutableLiveData<UIStateData<ArrayList<PictureItem>>> j2() {
        return this.mPictureItemList;
    }

    protected final void n2(int retCode, String errMsg, String groupId, int totalCommentNum, List<Comment> commentList, boolean hasMore, boolean isLoadMore, String attachInfo) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        QLog.e(getTAG(), 1, "handleCommentListResponse  retCode=" + retCode + ", errMsg=" + errMsg + ", commentList.size=" + (commentList != null ? Integer.valueOf(commentList.size()) : null) + ", hasMore=" + hasMore + ", isLoadMore=" + isLoadMore + ", attachInfo=" + attachInfo);
        if (retCode != 0) {
            L2(c2());
            UIStateData<BusinessFeedData> value = this.mFeedDetailData.getValue();
            J2(value != null ? value.getData() : null, false);
            H2(R.string.f133606k);
            QLog.e(getTAG(), 1, "getComment error:" + retCode + "  errorMsg:" + errMsg);
            return;
        }
        I2(attachInfo, hasMore, isLoadMore);
        M2(totalCommentNum);
        if (isLoadMore) {
            l2(commentList, hasMore, attachInfo);
        } else {
            m2(commentList, hasMore);
        }
    }

    public final boolean o2() {
        return this.commentResponse.getHasMore() && this.commentResponse.getHasResponse();
    }

    public final boolean p2() {
        return this.rightList.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMUPLOADMEDIA.ordinal()));
    }

    /* renamed from: q2, reason: from getter */
    public final boolean getFromArk() {
        return this.fromArk;
    }

    public final void r2() {
        if (o2()) {
            y2(true);
        }
    }

    public final void u2(Intent intent) {
        String stringExtra;
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.pageStartTimeMs = System.currentTimeMillis();
        this.fromArk = intent.getBooleanExtra("fromark", false);
        this.fromEntry = intent.getIntExtra("fromEntry", -1);
        BusinessFeedData e26 = e2();
        if (X1()) {
            if (this.fromArk || (stringExtra = intent.getStringExtra("feed_id")) == null) {
                stringExtra = "";
            }
            this.mFeedId = stringExtra;
            String stringExtra2 = intent.getStringExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.groupId = stringExtra2;
            String stringExtra3 = intent.getStringExtra("albumid");
            if (stringExtra3 == null) {
                stringExtra3 = "";
            }
            this.albumId = stringExtra3;
            String stringExtra4 = intent.getStringExtra(s4.c.BATCHID);
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            this.batchId = stringExtra4;
            String stringExtra5 = intent.getStringExtra("llocid");
            this.llocId = stringExtra5 != null ? stringExtra5 : "";
            Z1();
        } else {
            String stringExtra6 = intent.getStringExtra("feed_id");
            if (stringExtra6 == null) {
                stringExtra6 = "";
            }
            this.mFeedId = stringExtra6;
            String stringExtra7 = intent.getStringExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
            if (stringExtra7 == null) {
                stringExtra7 = "";
            }
            this.groupId = stringExtra7;
            String stringExtra8 = intent.getStringExtra("albumid");
            if (stringExtra8 == null) {
                stringExtra8 = "";
            }
            this.albumId = stringExtra8;
            String stringExtra9 = intent.getStringExtra(s4.c.BATCHID);
            if (stringExtra9 == null) {
                stringExtra9 = "";
            }
            this.batchId = stringExtra9;
            this.llocId = "";
            if (com.qzone.reborn.util.i.b().d("group_album_upload_right_" + this.groupId, false)) {
                this.rightList.add(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMUPLOADMEDIA.ordinal()));
            }
            J2(e26, true);
        }
        v2(e26);
        RFWLog.e("GroupAlbumFeedDetailServerRepo", RFWLog.USR, "getQunFeedDetail1 groupId:" + this.groupId + "  mFeedId\uff1a" + this.mFeedId + " fromArk:" + this.fromArk);
    }

    public final void J2(BusinessFeedData businessDetailData, boolean fromCache) {
        K2(businessDetailData, fromCache, false);
    }

    private final void m2(List<Comment> commentList, boolean hasMore) {
        if (commentList == null) {
            new ArrayList();
            QLog.e(getTAG(), 1, "\u540e\u53f0\u8fd4\u56de\u8bc4\u8bba\u6570\u4e3a0");
        }
        L2(commentList);
        UIStateData<BusinessFeedData> value = this.mFeedDetailData.getValue();
        J2(value != null ? value.getData() : null, false);
    }

    public final void Z1() {
        if (!this.fromArk) {
            String str = this.mFeedId;
            if (str == null || str.length() == 0) {
                RFWLog.d("GroupAlbumFeedDetailViewModel", RFWLog.USR, "request feed detail error, feed id is null");
                t2(this, "request feed detail error, feed id is null", 0L, 2, null);
                return;
            }
        }
        RFWLog.e("GroupAlbumFeedDetailViewModel", RFWLog.USR, "doRefresh groupId:" + this.groupId + "  mFeedId\uff1a" + this.mFeedId + " fromArk:" + this.fromArk + " batchId:" + this.batchId);
        if (!NetworkUtil.isNetworkAvailable()) {
            t2(this, com.qzone.util.l.a(R.string.f1330351), 0L, 2, null);
        } else {
            this.mFeedDetailRepo.c(this.fromArk, this.mFeedId, this.groupId, this.albumId, this.batchId, this.llocId, new c(), new Function1<String, Unit>() { // from class: com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel$doRefresh$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String mediaAttach) {
                    LoadInfo loadInfo;
                    LoadInfo loadInfo2;
                    Intrinsics.checkNotNullParameter(mediaAttach, "mediaAttach");
                    GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = GroupAlbumFeedDetailViewModel.this;
                    loadInfo = groupAlbumFeedDetailViewModel.mMediaListLoadInfo;
                    loadInfo.setStringAttachInfo(mediaAttach);
                    loadInfo2 = groupAlbumFeedDetailViewModel.mMediaListLoadInfo;
                    loadInfo2.setFinish(TextUtils.isEmpty(mediaAttach));
                }
            });
        }
    }

    public final void y2(boolean isLoadMore) {
        D2(isLoadMore ? this.commentResponse.getAttachInfo() : null, isLoadMore);
    }

    public final void z2(final boolean isLoadMore) {
        if (!isLoadMore) {
            C2();
        }
        QLog.d(getTAG(), 1, "requestGetAlbumBatchList  attachInfo : " + this.mMediaListLoadInfo.getStringAttachInfo() + " | isLoadMore : " + isLoadMore + " }");
        if (isLoadMore && this.mMediaListLoadInfo.isFinish()) {
            return;
        }
        this.mMediaListLoadInfo.setCurrentState(isLoadMore ? 3 : 2);
        final long currentTimeMillis = System.currentTimeMillis();
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.mAlbumDetailInitBean;
        if (groupAlbumAlbumDetailInitBean != null) {
            ki.a.f412421a.b(groupAlbumAlbumDetailInitBean.getGroupId(), groupAlbumAlbumDetailInitBean.getAlbumId(), "", groupAlbumAlbumDetailInitBean.getBatchId(), this.mMediaListLoadInfo.getStringAttachInfo(), new IAlbumServiceGetMediaListCallback() { // from class: com.qzone.reborn.groupalbum.viewmodel.s
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMediaListCallback
                public final void onGetMediaList(NTGetMediaListRsp nTGetMediaListRsp) {
                    GroupAlbumFeedDetailViewModel.A2(currentTimeMillis, this, isLoadMore, nTGetMediaListRsp);
                }
            });
        }
    }

    public final void K2(BusinessFeedData businessDetailData, boolean fromCache, boolean isRefresh) {
        if (businessDetailData == null) {
            QLog.e(getTAG(), 1, "updateDetailData: businessDetailData is null");
            return;
        }
        UIStateData<BusinessFeedData> obtainSuccess = UIStateData.obtainSuccess(false);
        obtainSuccess.setDataList(businessDetailData);
        obtainSuccess.setFinish(true);
        this.mFeedDetailData.setValue(obtainSuccess);
        if (TextUtils.isEmpty(ef.b.a(businessDetailData))) {
            return;
        }
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.c(ef.b.a(businessDetailData), businessDetailData.cellLikeInfo), true);
        if (!isRefresh) {
            af.b bVar = new af.b(ef.b.a(businessDetailData), businessDetailData.getCommentInfoV2());
            bVar.e(true);
            ze.a.a().initOrUpdateGlobalState((ze.a) bVar, true);
        }
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.d(ef.b.a(businessDetailData), businessDetailData.getVisitorInfo()), true);
        b2(businessDetailData);
    }

    static /* synthetic */ void t2(GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel, String str, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        groupAlbumFeedDetailViewModel.s2(str, j3);
    }
}
