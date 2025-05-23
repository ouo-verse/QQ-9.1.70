package com.qzone.reborn.message.part;

import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentEssence;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.feedx.util.aa;
import com.qzone.reborn.message.event.QZoneNoticeReplySuccessEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.IActivityLauncherProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001e\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001kB-\u0012\b\b\u0002\u0010B\u001a\u00020\u0010\u0012\b\b\u0002\u0010E\u001a\u00020\u0010\u0012\u0010\b\u0002\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0F\u00a2\u0006\u0004\bi\u0010jJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002JD\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J4\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0016J\u0012\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\"\u0010-\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010/\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010.\u001a\u00020*H\u0016J\u0012\u00101\u001a\u0004\u0018\u00010\u00152\b\u00100\u001a\u0004\u0018\u00010\u0013J\u0012\u00103\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u00105\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010\bH\u0016J$\u00106\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010.\u001a\u00020*H\u0016J8\u0010=\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010!2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u00109\u001a\u0004\u0018\u0001082\b\u0010;\u001a\u0004\u0018\u00010:2\u0006\u0010<\u001a\u00020*H\u0016R\u0017\u0010B\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010E\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\bC\u0010?\u001a\u0004\bD\u0010AR\u001f\u0010L\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0F8\u0006\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010NR\u0016\u0010V\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010NR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010g\u00a8\u0006l"}, d2 = {"Lcom/qzone/reborn/message/part/QZonePassiveMessageFeedCommentPart;", "Lcom/qzone/reborn/base/k;", "Lgf/a;", "Lcom/qzone/common/business/result/QZoneResult;", "result", "", "M9", "O9", "Landroid/content/Intent;", "data", "E9", "Lcom/qzone/reborn/feedx/bean/c;", "J9", "K9", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "commentResult", "", "isDoneComment", "", "", "H9", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Lcom/qzone/proxy/feedcomponent/model/User;", "targetUser", "content", QCircleSchemeAttr.Detail.COMMENT_ID, "fakeUniKey", "extendInfo", "G9", "F9", "I9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/qzone/reborn/feedx/bean/b;", "dataInfo", "f6", "Lcom/qzone/proxy/feedcomponent/model/ClickedComment;", "clickedComment", "x1", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "position", "z1", "cacheFeedKey", "L9", "commentBean", ICustomDataEditor.STRING_PARAM_6, "intent", ICustomDataEditor.STRING_ARRAY_PARAM_9, "c1", "v", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "dataPosInList", "H7", "d", "Z", "getShowSuccessToast", "()Z", "showSuccessToast", "e", "getNeedFakeComment", "needFakeComment", "Ljava/lang/Class;", "Lhl/d;", "f", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "viewModelClass", tl.h.F, "I", "mFeedPosition", "i", "Lcom/qzone/proxy/feedcomponent/model/ClickedComment;", "mClickComment", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mPreAction", BdhLogUtil.LogTag.Tag_Conn, "mShowQuickComment", "D", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "mFeedData", "E", "Lhl/d;", "mMessageViewModel", "Lxg/b;", UserInfo.SEX_FEMALE, "Lxg/b;", "mCommentClickProcess", "Lxg/c;", "G", "Lxg/c;", "mCommentLongClickProcess", "com/qzone/reborn/message/part/QZonePassiveMessageFeedCommentPart$b", "H", "Lcom/qzone/reborn/message/part/QZonePassiveMessageFeedCommentPart$b;", "mHandler", "<init>", "(ZZLjava/lang/Class;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePassiveMessageFeedCommentPart extends com.qzone.reborn.base.k implements gf.a {

    /* renamed from: C, reason: from kotlin metadata */
    private int mShowQuickComment;

    /* renamed from: D, reason: from kotlin metadata */
    private BusinessFeedData mFeedData;

    /* renamed from: E, reason: from kotlin metadata */
    private hl.d mMessageViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private xg.b mCommentClickProcess;

    /* renamed from: G, reason: from kotlin metadata */
    private xg.c mCommentLongClickProcess;

    /* renamed from: H, reason: from kotlin metadata */
    private final b mHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean showSuccessToast;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean needFakeComment;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Class<? extends hl.d> viewModelClass;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mFeedPosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ClickedComment mClickComment;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mPreAction;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/message/part/QZonePassiveMessageFeedCommentPart$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.handleMessage(msg2);
            QZoneResult unpack = QZoneResult.unpack(msg2);
            if (unpack == null) {
                return;
            }
            int i3 = unpack.what;
            if (i3 == 999905 || i3 == 999907) {
                QZonePassiveMessageFeedCommentPart.this.M9(unpack);
            }
        }
    }

    public /* synthetic */ QZonePassiveMessageFeedCommentPart(boolean z16, boolean z17, Class cls, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? hl.d.class : cls);
    }

    private final void F9(BusinessFeedData feedData, final String content, final String fakeUniKey, final Map<String, String> extendInfo) {
        hl.d dVar = this.mMessageViewModel;
        if (dVar != null) {
            dVar.f2(feedData, new Function1<BusinessFeedData, Unit>() { // from class: com.qzone.reborn.message.part.QZonePassiveMessageFeedCommentPart$fakeCommentFeed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BusinessFeedData businessFeedData) {
                    invoke2(businessFeedData);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
                
                    if (r0 != null) goto L20;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
                
                    if ((r6 == null || r6.isEmpty()) != false) goto L43;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(BusinessFeedData businessFeedData) {
                    if (businessFeedData == null) {
                        return;
                    }
                    CellCommentInfo commentInfoV2 = businessFeedData.getOriginalInfoSafe().getCommentInfoV2();
                    if (commentInfoV2 != null) {
                        ArrayList<Comment> arrayList = commentInfoV2.commments;
                        if (!(!(arrayList == null || arrayList.isEmpty()))) {
                            commentInfoV2 = null;
                        }
                    }
                    commentInfoV2 = businessFeedData.getCommentInfo();
                    if (businessFeedData.hasHighFive) {
                        businessFeedData.hasHighFive = false;
                    }
                    ArrayList<Comment> arrayList2 = new ArrayList<>();
                    ArrayList<Comment> arrayList3 = commentInfoV2.commments;
                    if (arrayList3 != null) {
                        arrayList2.addAll(arrayList3);
                    }
                    if (com.qzone.adapter.feedcomponent.f.a(businessFeedData, arrayList2, content, fakeUniKey, null, null, extendInfo, 0)) {
                        commentInfoV2.commments = arrayList2;
                        commentInfoV2.commentNum++;
                        int i3 = commentInfoV2.realCount;
                        if (i3 > 0) {
                            commentInfoV2.realCount = i3 + 1;
                        }
                        ArrayList<Comment> arrayList4 = new ArrayList<>();
                        CellCommentEssence commentEssence = businessFeedData.getOriginalInfoSafe() != null ? businessFeedData.getOriginalInfoSafe().getCommentEssence() : null;
                        if (commentEssence != null) {
                            ArrayList<Comment> arrayList5 = commentEssence.commments;
                        }
                        commentEssence = businessFeedData.getCommentEssence();
                        CellCommentEssence cellCommentEssence = commentEssence;
                        if (cellCommentEssence != null) {
                            ArrayList<Comment> arrayList6 = cellCommentEssence.commments;
                            if (arrayList6 != null) {
                                arrayList4.addAll(arrayList6);
                            }
                            if (!com.qzone.adapter.feedcomponent.f.a(businessFeedData, arrayList4, content, fakeUniKey, null, null, extendInfo, 1)) {
                                return;
                            }
                            cellCommentEssence.commments = arrayList4;
                            cellCommentEssence.commentNum++;
                        }
                        commentInfoV2.commentNumInfoFoldText = null;
                        businessFeedData.feedInfo = "";
                    }
                }
            });
        }
    }

    private final void G9(BusinessFeedData feedData, final User targetUser, final String content, final String commentid, final String fakeUniKey, final Map<String, String> extendInfo) {
        hl.d dVar = this.mMessageViewModel;
        if (dVar != null) {
            dVar.f2(feedData, new Function1<BusinessFeedData, Unit>() { // from class: com.qzone.reborn.message.part.QZonePassiveMessageFeedCommentPart$fakeReplyFeed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BusinessFeedData businessFeedData) {
                    invoke2(businessFeedData);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:39:0x00b7, code lost:
                
                    if (r16.feedType != 2) goto L44;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(BusinessFeedData businessFeedData) {
                    if (businessFeedData == null) {
                        return;
                    }
                    ArrayList<Comment> arrayList = new ArrayList<>();
                    CellCommentInfo commentInfo = businessFeedData.getOriginalInfoSafe().getCommentInfo();
                    Intrinsics.checkNotNullExpressionValue(commentInfo, "uiFeedData.getOriginalInfoSafe().getCommentInfo()");
                    ArrayList<Comment> arrayList2 = commentInfo.commments;
                    if (arrayList2 == null || arrayList2.isEmpty() || businessFeedData.feedType == 2) {
                        commentInfo = businessFeedData.getCommentInfo();
                        Intrinsics.checkNotNullExpressionValue(commentInfo, "uiFeedData.getCommentInfo()");
                    }
                    CellCommentInfo cellCommentInfo = commentInfo;
                    ArrayList<Comment> arrayList3 = cellCommentInfo.commments;
                    if (arrayList3 != null) {
                        arrayList.addAll(arrayList3);
                    }
                    if (arrayList.isEmpty()) {
                        CellCommentInfo commentInfo2 = businessFeedData.getOriginalInfoSafe().getCommentInfo();
                        Intrinsics.checkNotNullExpressionValue(commentInfo2, "uiFeedData.getOriginalInfoSafe().getCommentInfo()");
                        Comment comment = commentInfo2.mainComment;
                        if (comment != null && !TextUtils.isEmpty(comment.commentid)) {
                            arrayList.add(commentInfo2.mainComment);
                            if (!arrayList.isEmpty()) {
                                arrayList.get(0).commentPictureItems = businessFeedData.getCellSummary().summarypic;
                            }
                        }
                    }
                    if (com.qzone.adapter.feedcomponent.f.b(businessFeedData, arrayList, User.this, content, commentid, fakeUniKey, null, true, extendInfo)) {
                        cellCommentInfo.commments = arrayList;
                        int i3 = cellCommentInfo.realCount;
                        if (i3 > 0) {
                            cellCommentInfo.realCount = i3 + 1;
                        }
                        ArrayList<Comment> arrayList4 = new ArrayList<>();
                        CellCommentEssence commentEssence = businessFeedData.getOriginalInfoSafe() != null ? businessFeedData.getOriginalInfoSafe().getCommentEssence() : null;
                        if (commentEssence != null) {
                            ArrayList<Comment> arrayList5 = commentEssence.commments;
                            if (!(arrayList5 == null || arrayList5.isEmpty())) {
                            }
                        }
                        commentEssence = businessFeedData.getCommentEssence();
                        CellCommentEssence cellCommentEssence = commentEssence;
                        if (cellCommentEssence != null) {
                            ArrayList<Comment> arrayList6 = cellCommentEssence.commments;
                            if (arrayList6 != null) {
                                arrayList4.addAll(arrayList6);
                            }
                            if (!com.qzone.adapter.feedcomponent.f.b(businessFeedData, arrayList4, User.this, content, commentid, fakeUniKey, null, true, extendInfo)) {
                                return;
                            } else {
                                cellCommentEssence.commments = arrayList4;
                            }
                        }
                        businessFeedData.feedInfo = "";
                    }
                }
            });
        }
    }

    private final Map<String, String> H9(QZoneCommentPanelResultBean commentResult, boolean isDoneComment) {
        Map<String, String> mutableMap;
        CellCommentInfo commentInfoV2;
        mutableMap = MapsKt__MapsKt.toMutableMap(commentResult.a());
        if (isDoneComment) {
            String g16 = aa.g(this.mFeedData);
            if (!TextUtils.isEmpty(g16)) {
                mutableMap.put("hittext", g16);
            }
            BusinessFeedData businessFeedData = this.mFeedData;
            if ((businessFeedData != null ? businessFeedData.getFeedCommInfoV2() : null) != null) {
                BusinessFeedData businessFeedData2 = this.mFeedData;
                Intrinsics.checkNotNull(businessFeedData2);
                long j3 = businessFeedData2.getFeedCommInfoV2().time / 1000;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j3);
                mutableMap.put("tid_create_time", sb5.toString());
            }
            BusinessFeedData businessFeedData3 = this.mFeedData;
            boolean z16 = false;
            if (businessFeedData3 != null && (commentInfoV2 = businessFeedData3.getCommentInfoV2()) != null && !commentInfoV2.hasComments()) {
                z16 = true;
            }
            if (z16) {
                mutableMap.put("no_cmt_list", "1");
            }
        }
        QLog.i("QZonePassiveMessageFeedCommentPart", 1, "doneComment  feedData = " + this.mFeedData);
        return mutableMap;
    }

    private final String I9() {
        gf.k kVar = (gf.k) getIocInterface(gf.k.class);
        if (kVar == null) {
            return "";
        }
        String h16 = fo.c.h(kVar.getPageType());
        Intrinsics.checkNotNullExpressionValue(h16, "{\n            QZoneDaTon\u2026.getPageType())\n        }");
        return h16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(QZoneResult result) {
        String str;
        if (result.getSucceed()) {
            if (this.showSuccessToast) {
                com.qzone.reborn.util.o.f59556a.c(R.string.wbg, 2);
            } else {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                BusinessFeedData businessFeedData = this.mFeedData;
                if (businessFeedData == null || (str = com.qzone.reborn.message.data.e.q(businessFeedData)) == null) {
                    str = "";
                }
                simpleEventBus.dispatchEvent(new QZoneNoticeReplySuccessEvent(str, this.mFeedPosition));
            }
        } else {
            c6.a.i(result.getMessage());
        }
        O9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QZonePassiveMessageFeedCommentPart this$0, Intent intent, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B9(intent, i3);
    }

    @Override // gf.a
    public void H7(View v3, BusinessFeedData feedData, Comment comment, Reply reply, int dataPosInList) {
        if (this.mCommentLongClickProcess == null) {
            xg.c cVar = new xg.c(getActivity());
            this.mCommentLongClickProcess = cVar;
            cVar.o(this);
        }
        xg.c cVar2 = this.mCommentLongClickProcess;
        if (cVar2 != null) {
            cVar2.n(v3, comment, reply);
        }
    }

    public final BusinessFeedData L9(String cacheFeedKey) {
        hl.d dVar;
        List<BusinessFeedData> W1;
        if (!TextUtils.isEmpty(cacheFeedKey) && (dVar = this.mMessageViewModel) != null && (W1 = dVar.W1()) != null) {
            for (BusinessFeedData businessFeedData : W1) {
                if (businessFeedData.getFeedCommInfo() != null && TextUtils.equals(cacheFeedKey, businessFeedData.getFeedCommInfo().feedskey)) {
                    return businessFeedData;
                }
            }
        }
        return null;
    }

    @Override // gf.a
    public void c1(BusinessFeedData feedData, ClickedComment clickedComment, int position) {
        if (this.mCommentClickProcess == null) {
            xg.b bVar = new xg.b(getHostFragment(), new IActivityLauncherProxy() { // from class: com.qzone.reborn.message.part.o
                @Override // cooperation.qzone.api.IActivityLauncherProxy
                public final void startActivityForResult(Intent intent, int i3) {
                    QZonePassiveMessageFeedCommentPart.N9(QZonePassiveMessageFeedCommentPart.this, intent, i3);
                }
            });
            this.mCommentClickProcess = bVar;
            bVar.d(this);
            xg.b bVar2 = this.mCommentClickProcess;
            if (bVar2 != null) {
                bVar2.e(I9());
            }
        }
        xg.b bVar3 = this.mCommentClickProcess;
        if (bVar3 != null) {
            bVar3.f(this.mShowQuickComment);
        }
        xg.b bVar4 = this.mCommentClickProcess;
        if (bVar4 != null) {
            bVar4.c(feedData, clickedComment, position);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePassiveMessageFeedCommentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 1208) {
            E9(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, gf.a.class);
        this.mMessageViewModel = (hl.d) getViewModel(this.viewModelClass);
    }

    @Override // gf.a
    public void x1(ClickedComment clickedComment) {
        this.mClickComment = clickedComment;
    }

    private final com.qzone.reborn.feedx.bean.c K9(Intent data) {
        if (data == null) {
            QLog.e("QZonePassiveMessageFeedCommentPart", 1, "[getDoneCommentBeanNew] data is null");
            return null;
        }
        Parcelable parcelableExtra = data.getParcelableExtra("comment_panel_result_bean");
        if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
            QLog.e("QZonePassiveMessageFeedCommentPart", 1, "[getDoneCommentBeanNew] bean is not instanceof");
            return null;
        }
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
        if (TextUtils.isEmpty(qZoneCommentPanelResultBean.getInputContent()) && bl.b(qZoneCommentPanelResultBean.g())) {
            QLog.e("QZonePassiveMessageFeedCommentPart", 1, "doneComment  commentText and pic is null");
            return null;
        }
        return new com.qzone.reborn.feedx.bean.c().o(qZoneCommentPanelResultBean.getInputContent()).r(this.mFeedPosition).n(this.mClickComment).v("").m(qZoneCommentPanelResultBean.getCacheUniKey()).s(qZoneCommentPanelResultBean.getIsCheckedPrivateIcon()).q(qZoneCommentPanelResultBean.g()).l(qZoneCommentPanelResultBean.getCacheFeedsKey()).t(qZoneCommentPanelResultBean.getIsEmoRapidComment()).u(qZoneCommentPanelResultBean.getRapidCommentInfo()).p(H9(qZoneCommentPanelResultBean, true));
    }

    private final void O9() {
        this.mFeedPosition = 0;
        this.mClickComment = null;
    }

    public QZonePassiveMessageFeedCommentPart(boolean z16, boolean z17, Class<? extends hl.d> viewModelClass) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        this.showSuccessToast = z16;
        this.needFakeComment = z17;
        this.viewModelClass = viewModelClass;
        this.mHandler = new b(Looper.getMainLooper());
    }

    private final com.qzone.reborn.feedx.bean.c J9(Intent data) {
        if (data == null) {
            QLog.e("QZonePassiveMessageFeedCommentPart", 1, "[getDoneReplyBean] data is null");
            return null;
        }
        String stringExtra = data.getStringExtra("contentIntentKey");
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.e("QZonePassiveMessageFeedCommentPart", 1, "doneReply  commentText == null");
            return null;
        }
        String stringExtra2 = data.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY);
        String stringExtra3 = data.getStringExtra("cache_feedkey");
        boolean booleanExtra = data.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIVATE_COMMENT, false);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(data.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL))) {
            int intExtra = data.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, 0);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(intExtra);
            hashMap.put("diy_font_id", sb5.toString());
            int intExtra2 = data.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, 0);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(intExtra2);
            hashMap.put("diy_font_type", sb6.toString());
            hashMap.put("diy_font_url", data.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL));
        }
        if (!TextUtils.isEmpty(data.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO))) {
            int intExtra3 = data.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, 0);
            StringBuilder sb7 = new StringBuilder();
            sb7.append(intExtra3);
            hashMap.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, sb7.toString());
            hashMap.put("sparkle_json", data.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO));
        }
        if (!TextUtils.isEmpty(data.getStringExtra("extra_key_barrage_effect_info"))) {
            int intExtra4 = data.getIntExtra("extra_key_barrage_effect_id", 0);
            StringBuilder sb8 = new StringBuilder();
            sb8.append(intExtra4);
            hashMap.put(UNIVERSAL_MALL_QUAL.value, sb8.toString());
            hashMap.put("private_barrage_data", data.getStringExtra("extra_key_barrage_effect_info"));
        }
        return new com.qzone.reborn.feedx.bean.c().o(stringExtra).r(this.mFeedPosition).v("").m(stringExtra2).s(booleanExtra).t(false).l(stringExtra3).p(hashMap);
    }

    private final void E9(Intent data) {
        if (data == null) {
            return;
        }
        if (cd.b.a()) {
            s6(K9(data));
        } else {
            s6(J9(data));
        }
    }

    @Override // gf.a
    public void f6(com.qzone.reborn.feedx.bean.b dataInfo) {
        if (dataInfo == null) {
            return;
        }
        this.mFeedData = dataInfo.f54743d;
        this.mFeedPosition = dataInfo.f54740a;
        this.mPreAction = dataInfo.f54741b;
        this.mShowQuickComment = dataInfo.f54742c;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0089  */
    @Override // gf.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s6(com.qzone.reborn.feedx.bean.c commentBean) {
        BusinessFeedData L9;
        String str;
        long j3;
        Comment comment;
        User user;
        String str2;
        long j16;
        String str3;
        QZonePassiveMessageFeedCommentPart qZonePassiveMessageFeedCommentPart;
        String str4;
        User user2;
        if (commentBean == null || (L9 = L9(commentBean.a())) == null) {
            return;
        }
        CellOperationInfo operationInfoV2 = L9.getOperationInfoV2();
        Map<Integer, String> map = operationInfoV2 != null ? operationInfoV2.busiParam : null;
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(41, "source=1&from_notify=0");
        BusinessFeedData originalInfoSafe = L9.getOriginalInfoSafe();
        int i3 = L9.getFeedCommInfo().actiontype;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 8) {
                    if (i3 != 9) {
                        str = originalInfoSafe.getIdInfo().cellId;
                        j3 = originalInfoSafe.getUser().uin;
                        if (TextUtils.isEmpty(str)) {
                            str = L9.getIdInfo().cellId;
                            j3 = L9.getUser().uin;
                        }
                        long j17 = j3;
                        CellCommentInfo commentInfoV2 = originalInfoSafe.getCommentInfoV2();
                        comment = commentInfoV2 != null ? commentInfoV2.mainComment : null;
                        String str5 = "";
                        if (comment == null && !comment.isFake) {
                            user = L9.getUser();
                            long j18 = comment.user.uin;
                            str2 = comment.commentid;
                            Intrinsics.checkNotNullExpressionValue(str2, "mainComment.commentid");
                            j16 = j18;
                        } else {
                            user = L9.getFeedCommInfo().appid == 333 ? L9.getUser() : null;
                            str2 = "";
                            j16 = 0;
                        }
                        if (L9.getFeedCommInfo().appid == 4) {
                            str5 = "getPassiveFeeds";
                        }
                        String str6 = str5;
                        String uuid = UUID.randomUUID().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
                        if (j16 != 0) {
                            if (commentBean.c() != null) {
                                if (commentBean.c().getReply() != null) {
                                    user2 = commentBean.c().getReply().user;
                                    Intrinsics.checkNotNullExpressionValue(user2, "{\n                    co\u2026ly.user\n                }");
                                } else {
                                    user2 = commentBean.c().getComment().user;
                                    Intrinsics.checkNotNullExpressionValue(user2, "{\n                    co\u2026nt.user\n                }");
                                }
                                String str7 = commentBean.c().getComment().commentid;
                                Intrinsics.checkNotNullExpressionValue(str7, "commentBean.clickedComment.comment.commentid");
                                QZoneWriteOperationService.v0().c2(this.mHandler, L9.getFeedCommInfo().ugckey, L9.getFeedCommInfo().feedskey, uuid, L9.getFeedCommInfo().appid, j17, j16, user2, str, "", str7, com.qzone.util.u.a(user2.uin, user2.nickName) + commentBean.d(), commentBean.d(), commentBean.b(), 0, map, str6, L9.getFeedCommInfo().isTodayInHistoryFeed(), commentBean.g(), 3, commentBean.e());
                                String d16 = commentBean.d();
                                Intrinsics.checkNotNullExpressionValue(d16, "commentBean.commentText");
                                Map<String, String> e16 = commentBean.e();
                                Intrinsics.checkNotNullExpressionValue(e16, "commentBean.extendInfo");
                                G9(L9, user2, d16, str7, uuid, e16);
                                return;
                            }
                            QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
                            b bVar = this.mHandler;
                            String str8 = L9.getFeedCommInfo().ugckey;
                            String str9 = L9.getFeedCommInfo().feedskey;
                            int i16 = L9.getFeedCommInfo().appid;
                            Intrinsics.checkNotNull(user);
                            v06.c2(bVar, str8, str9, uuid, i16, j17, j16, user, str, "", str2, com.qzone.util.u.a(user.uin, user.nickName) + commentBean.d(), commentBean.d(), commentBean.b(), 0, map, str6, false, commentBean.g(), 3, commentBean.e());
                            String d17 = commentBean.d();
                            Intrinsics.checkNotNullExpressionValue(d17, "commentBean.commentText");
                            Map<String, String> e17 = commentBean.e();
                            Intrinsics.checkNotNullExpressionValue(e17, "commentBean.extendInfo");
                            G9(L9, user, d17, str2, uuid, e17);
                            return;
                        }
                        if (L9.getLocalInfo().canComment || L9.getLocalInfo().canReply) {
                            str3 = "commentBean.commentText";
                            qZonePassiveMessageFeedCommentPart = this;
                            if (L9.getFeedCommInfo().appid != 334) {
                                j17 = L9.getUser().uin;
                            } else if (originalInfoSafe.getUser() != null) {
                                j17 = originalInfoSafe.getUser().uin;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = originalInfoSafe.getIdInfo().cellId;
                                if (originalInfoSafe.getUser() != null) {
                                    str4 = str;
                                    j17 = originalInfoSafe.getUser().uin;
                                    QZoneWriteOperationService.v0().R(qZonePassiveMessageFeedCommentPart.mHandler, L9.getFeedCommInfo().ugckey, L9.getFeedCommInfo().feedskey, uuid, L9.getFeedCommInfo().appid, j17, str4, commentBean.d(), commentBean.b(), 0, map, L9.getLocalInfo().canComment, str6, L9.getUser(), L9.getFeedCommInfo().isTodayInHistoryFeed(), commentBean.j(), commentBean.e());
                                }
                            }
                            str4 = str;
                            QZoneWriteOperationService.v0().R(qZonePassiveMessageFeedCommentPart.mHandler, L9.getFeedCommInfo().ugckey, L9.getFeedCommInfo().feedskey, uuid, L9.getFeedCommInfo().appid, j17, str4, commentBean.d(), commentBean.b(), 0, map, L9.getLocalInfo().canComment, str6, L9.getUser(), L9.getFeedCommInfo().isTodayInHistoryFeed(), commentBean.j(), commentBean.e());
                        } else if (!L9.getLocalInfo().canReferComment) {
                            str3 = "commentBean.commentText";
                            qZonePassiveMessageFeedCommentPart = this;
                        } else {
                            if (user == null) {
                                user = L9.getUser();
                            }
                            if (user == null) {
                                str3 = "commentBean.commentText";
                            } else {
                                str3 = "commentBean.commentText";
                                commentBean.o(com.qzone.util.u.a(user.uin, user.nickName) + commentBean.d());
                            }
                            qZonePassiveMessageFeedCommentPart = this;
                            QZoneWriteOperationService.v0().R(this.mHandler, L9.getFeedCommInfo().ugckey, L9.getFeedCommInfo().feedskey, uuid, L9.getFeedCommInfo().appid, j17, str, commentBean.d(), commentBean.b(), 0, map, L9.getLocalInfo().canReferComment, str6, L9.getUser(), L9.getFeedCommInfo().isTodayInHistoryFeed(), commentBean.j(), commentBean.e());
                        }
                        if (qZonePassiveMessageFeedCommentPart.needFakeComment) {
                            String d18 = commentBean.d();
                            Intrinsics.checkNotNullExpressionValue(d18, str3);
                            Map<String, String> e18 = commentBean.e();
                            Intrinsics.checkNotNullExpressionValue(e18, "commentBean.extendInfo");
                            qZonePassiveMessageFeedCommentPart.F9(L9, d18, uuid, e18);
                            return;
                        }
                        return;
                    }
                }
            }
            str = originalInfoSafe.getIdInfo().cellId;
            j3 = originalInfoSafe.getUser().uin;
            long j172 = j3;
            CellCommentInfo commentInfoV22 = originalInfoSafe.getCommentInfoV2();
            if (commentInfoV22 != null) {
            }
            String str52 = "";
            if (comment == null) {
            }
            if (L9.getFeedCommInfo().appid == 333) {
            }
            str2 = "";
            j16 = 0;
            if (L9.getFeedCommInfo().appid == 4) {
            }
            String str62 = str52;
            String uuid2 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid2, "randomUUID().toString()");
            if (j16 != 0) {
            }
        }
        str = L9.getIdInfo().cellId;
        j3 = L9.getUser().uin;
        long j1722 = j3;
        CellCommentInfo commentInfoV222 = originalInfoSafe.getCommentInfoV2();
        if (commentInfoV222 != null) {
        }
        String str522 = "";
        if (comment == null) {
        }
        if (L9.getFeedCommInfo().appid == 333) {
        }
        str2 = "";
        j16 = 0;
        if (L9.getFeedCommInfo().appid == 4) {
        }
        String str622 = str522;
        String uuid22 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid22, "randomUUID().toString()");
        if (j16 != 0) {
        }
    }

    @Override // gf.a
    public void a9(Intent intent) {
    }

    @Override // gf.a
    public void z1(BusinessFeedData feedData, ClickedComment clickedComment, int position) {
    }
}
