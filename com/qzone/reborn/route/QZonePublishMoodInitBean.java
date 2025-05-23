package com.qzone.reborn.route;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.publish.bean.QZonePublishTagBean;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bW\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00b5\u00012\u00020\u0001:\u0001\u0019B\u0011\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0006\b\u00b2\u0001\u0010\u00b3\u0001B\u0013\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0006\b\u00b2\u0001\u0010\u00b4\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R$\u0010-\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R$\u00101\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0010\u001a\u0004\b/\u0010\u0012\"\u0004\b0\u0010\u0014R$\u00105\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010 \u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R$\u00108\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cR$\u0010<\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u0018\u001a\u0004\b:\u0010\u001a\"\u0004\b;\u0010\u001cR$\u0010@\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u0018\u001a\u0004\b>\u0010\u001a\"\u0004\b?\u0010\u001cR$\u0010D\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u0018\u001a\u0004\bB\u0010\u001a\"\u0004\bC\u0010\u001cR$\u0010K\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\b=\u0010H\"\u0004\bI\u0010JR$\u0010N\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\bL\u0010\u001a\"\u0004\bM\u0010\u001cR$\u0010R\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010 \u001a\u0004\bP\u0010\"\"\u0004\bQ\u0010$R6\u0010[\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010Sj\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010^\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010 \u001a\u0004\b\\\u0010\"\"\u0004\b]\u0010$R$\u0010a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0010\u001a\u0004\b_\u0010\u0012\"\u0004\b`\u0010\u0014R$\u0010e\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010 \u001a\u0004\bc\u0010\"\"\u0004\bd\u0010$R$\u0010i\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010 \u001a\u0004\bg\u0010\"\"\u0004\bh\u0010$R$\u0010m\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010\u0018\u001a\u0004\bk\u0010\u001a\"\u0004\bl\u0010\u001cR$\u0010q\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010 \u001a\u0004\bo\u0010\"\"\u0004\bp\u0010$R$\u0010u\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\br\u0010\u0018\u001a\u0004\bs\u0010\u001a\"\u0004\bt\u0010\u001cR$\u0010y\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010\u0018\u001a\u0004\bw\u0010\u001a\"\u0004\bx\u0010\u001cR$\u0010|\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0018\u001a\u0004\bz\u0010\u001a\"\u0004\b{\u0010\u001cR%\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b}\u0010\u0018\u001a\u0004\b~\u0010\u001a\"\u0004\b\u007f\u0010\u001cR(\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0081\u0001\u0010\u0018\u001a\u0005\b\u0082\u0001\u0010\u001a\"\u0005\b\u0083\u0001\u0010\u001cR(\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0085\u0001\u0010 \u001a\u0005\b\u0086\u0001\u0010\"\"\u0005\b\u0087\u0001\u0010$R&\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b/\u0010\u0010\u001a\u0004\b9\u0010\u0012\"\u0005\b\u0089\u0001\u0010\u0014R'\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u008b\u0001\u0010\u0018\u001a\u0004\b\u000f\u0010\u001a\"\u0005\b\u008c\u0001\u0010\u001cR'\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u008e\u0001\u0010\u0018\u001a\u0004\b\u0017\u0010\u001a\"\u0005\b\u008f\u0001\u0010\u001cR'\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bP\u0010\u0018\u001a\u0005\b\u0091\u0001\u0010\u001a\"\u0005\b\u0092\u0001\u0010\u001cR'\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bg\u0010\u0018\u001a\u0005\b\u008b\u0001\u0010\u001a\"\u0005\b\u0094\u0001\u0010\u001cR(\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0096\u0001\u0010\u0018\u001a\u0005\b\u008e\u0001\u0010\u001a\"\u0005\b\u0097\u0001\u0010\u001cR'\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b3\u0010\u0018\u001a\u0005\b\u0099\u0001\u0010\u001a\"\u0005\b\u009a\u0001\u0010\u001cR'\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bo\u0010\u0018\u001a\u0005\b\u009c\u0001\u0010\u001a\"\u0005\b\u009d\u0001\u0010\u001cR8\u0010\u00a0\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010Sj\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b!\u0010V\u001a\u0004\b.\u0010X\"\u0005\b\u009f\u0001\u0010ZR'\u0010\u00a3\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u001b\u0010\u0018\u001a\u0005\b\u00a1\u0001\u0010\u001a\"\u0005\b\u00a2\u0001\u0010\u001cR'\u0010\u00a6\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b7\u0010\u0018\u001a\u0005\b\u00a4\u0001\u0010\u001a\"\u0005\b\u00a5\u0001\u0010\u001cR(\u0010\u00a8\u0001\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0092\u0001\u0010 \u001a\u0005\b\u0096\u0001\u0010\"\"\u0005\b\u00a7\u0001\u0010$R(\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008c\u0001\u0010 \u001a\u0005\b\u00a9\u0001\u0010\"\"\u0005\b\u00aa\u0001\u0010$R)\u0010\u00b1\u0001\u001a\u00030\u00ac\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u008f\u0001\u0010\u00ad\u0001\u001a\u0005\b*\u0010\u00ae\u0001\"\u0006\b\u00af\u0001\u0010\u00b0\u0001\u00a8\u0006\u00b6\u0001"}, d2 = {"Lcom/qzone/reborn/route/QZonePublishMoodInitBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "J", "l", "()J", "enterTime", "e", "Ljava/lang/Integer;", "E", "()Ljava/lang/Integer;", "H0", "(Ljava/lang/Integer;)V", "startUpSceneId", "", "f", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "i0", "(Ljava/lang/String;)V", "action", "", h.F, "Ljava/lang/Boolean;", "h0", "()Ljava/lang/Boolean;", "R0", "(Ljava/lang/Boolean;)V", "isUploadVideo", "i", "r", "t0", "keyType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "v0", "needLoadPhotoFromIntent", BdhLogUtil.LogTag.Tag_Conn, "Z", "O0", "uploadEntrance", "D", "f0", "G0", "isShowNewCard", "b", "j0", "adId", UserInfo.SEX_FEMALE, "N", "L0", "tagTitle", "G", "V", "setTagUin", "tagUin", "H", "M", "K0", "tagProtocol", "Lcom/qzone/reborn/publish/bean/QZonePublishTagBean;", "I", "Lcom/qzone/reborn/publish/bean/QZonePublishTagBean;", "()Lcom/qzone/reborn/publish/bean/QZonePublishTagBean;", "J0", "(Lcom/qzone/reborn/publish/bean/QZonePublishTagBean;)V", "tagBean", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "C0", "refer", "K", "c0", "q0", "isFromEventTag", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "L", "Ljava/util/ArrayList;", "w", "()Ljava/util/ArrayList;", "y0", "(Ljava/util/ArrayList;)V", "photoPaths", ReportConstant.COSTREPORT_PREFIX, "u0", "needJumpToEditPage", "v", "x0", "operateType", "P", "u", "w0", "needSaveDraft", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "d0", "s0", "isJumpReeditPublishFlow", BdhLogUtil.LogTag.Tag_Req, "g", "n0", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, ExifInterface.LATITUDE_SOUTH, "g0", "N0", "isTrimVideoBlackList", "T", "y", "B0", "qzoneUin", "U", HippyTKDListViewAdapter.X, "A0", "qzoneNickname", DomainData.DOMAIN_NAME, "p0", "filePath", "W", "getTitle", "M0", "title", "X", "j", "setDescription", "description", "Y", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r0", "hideAddBtn", "I0", "stateType", "a0", "l0", "albumId", "b0", "m0", AEEditorConstants.ALBUMNAME, "c", "k0", "albumCover", "P0", "uploadImageClientKey", "e0", "Q0", "uploadPhotoComeFrom", "o", "setGroupId", "groupId", "p", "setGroupName", "groupName", "F0", "selectedImagePathList", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D0", "repairSrTaskId", "B", "E0", "repairSrUrl", "z0", "isPhotoRepairByOpr", "k", "o0", "enterByLongClick", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "setExtraBundleInfo", "(Landroid/os/Bundle;)V", "extraBundleInfo", "<init>", "(J)V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePublishMoodInitBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private Integer uploadEntrance;

    /* renamed from: D, reason: from kotlin metadata */
    private Boolean isShowNewCard;

    /* renamed from: E, reason: from kotlin metadata */
    private String adId;

    /* renamed from: F, reason: from kotlin metadata */
    private String tagTitle;

    /* renamed from: G, reason: from kotlin metadata */
    private String tagUin;

    /* renamed from: H, reason: from kotlin metadata */
    private String tagProtocol;

    /* renamed from: I, reason: from kotlin metadata */
    private QZonePublishTagBean tagBean;

    /* renamed from: J, reason: from kotlin metadata */
    private String refer;

    /* renamed from: K, reason: from kotlin metadata */
    private Boolean isFromEventTag;

    /* renamed from: L, reason: from kotlin metadata */
    private ArrayList<String> photoPaths;

    /* renamed from: M, reason: from kotlin metadata */
    private Boolean needJumpToEditPage;

    /* renamed from: N, reason: from kotlin metadata */
    private Integer operateType;

    /* renamed from: P, reason: from kotlin metadata */
    private Boolean needSaveDraft;

    /* renamed from: Q, reason: from kotlin metadata */
    private Boolean isJumpReeditPublishFlow;

    /* renamed from: R, reason: from kotlin metadata */
    private String defaultText;

    /* renamed from: S, reason: from kotlin metadata */
    private Boolean isTrimVideoBlackList;

    /* renamed from: T, reason: from kotlin metadata */
    private String qzoneUin;

    /* renamed from: U, reason: from kotlin metadata */
    private String qzoneNickname;

    /* renamed from: V, reason: from kotlin metadata */
    private String filePath;

    /* renamed from: W, reason: from kotlin metadata */
    private String title;

    /* renamed from: X, reason: from kotlin metadata */
    private String description;

    /* renamed from: Y, reason: from kotlin metadata */
    private Boolean hideAddBtn;

    /* renamed from: Z, reason: from kotlin metadata */
    private Integer stateType;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private String albumName;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String albumCover;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long enterTime;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private String uploadImageClientKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Integer startUpSceneId;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private String uploadPhotoComeFrom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String action;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private String groupId;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private String groupName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Boolean isUploadVideo;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private ArrayList<String> selectedImagePathList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Integer keyType;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private String repairSrTaskId;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private String repairSrUrl;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private Boolean isPhotoRepairByOpr;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private Boolean enterByLongClick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Boolean needLoadPhotoFromIntent;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private Bundle extraBundleInfo;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/route/QZonePublishMoodInitBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/route/QZonePublishMoodInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/route/QZonePublishMoodInitBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.route.QZonePublishMoodInitBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QZonePublishMoodInitBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZonePublishMoodInitBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZonePublishMoodInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZonePublishMoodInitBean[] newArray(int size) {
            return new QZonePublishMoodInitBean[size];
        }

        Companion() {
        }
    }

    public QZonePublishMoodInitBean(long j3) {
        this.enterTime = j3;
        this.extraBundleInfo = new Bundle();
    }

    /* renamed from: A, reason: from getter */
    public final String getRepairSrTaskId() {
        return this.repairSrTaskId;
    }

    public final void A0(String str) {
        this.qzoneNickname = str;
    }

    /* renamed from: B, reason: from getter */
    public final String getRepairSrUrl() {
        return this.repairSrUrl;
    }

    public final void B0(String str) {
        this.qzoneUin = str;
    }

    public final ArrayList<String> C() {
        return this.selectedImagePathList;
    }

    public final void C0(String str) {
        this.refer = str;
    }

    public final void D0(String str) {
        this.repairSrTaskId = str;
    }

    /* renamed from: E, reason: from getter */
    public final Integer getStartUpSceneId() {
        return this.startUpSceneId;
    }

    public final void E0(String str) {
        this.repairSrUrl = str;
    }

    /* renamed from: F, reason: from getter */
    public final Integer getStateType() {
        return this.stateType;
    }

    public final void F0(ArrayList<String> arrayList) {
        this.selectedImagePathList = arrayList;
    }

    /* renamed from: G, reason: from getter */
    public final QZonePublishTagBean getTagBean() {
        return this.tagBean;
    }

    public final void G0(Boolean bool) {
        this.isShowNewCard = bool;
    }

    public final void H0(Integer num) {
        this.startUpSceneId = num;
    }

    public final void I0(Integer num) {
        this.stateType = num;
    }

    public final void J0(QZonePublishTagBean qZonePublishTagBean) {
        this.tagBean = qZonePublishTagBean;
    }

    public final void K0(String str) {
        this.tagProtocol = str;
    }

    public final void L0(String str) {
        this.tagTitle = str;
    }

    /* renamed from: M, reason: from getter */
    public final String getTagProtocol() {
        return this.tagProtocol;
    }

    public final void M0(String str) {
        this.title = str;
    }

    /* renamed from: N, reason: from getter */
    public final String getTagTitle() {
        return this.tagTitle;
    }

    public final void N0(Boolean bool) {
        this.isTrimVideoBlackList = bool;
    }

    public final void O0(Integer num) {
        this.uploadEntrance = num;
    }

    public final void P0(String str) {
        this.uploadImageClientKey = str;
    }

    public final void Q0(String str) {
        this.uploadPhotoComeFrom = str;
    }

    public final void R0(Boolean bool) {
        this.isUploadVideo = bool;
    }

    /* renamed from: V, reason: from getter */
    public final String getTagUin() {
        return this.tagUin;
    }

    /* renamed from: Z, reason: from getter */
    public final Integer getUploadEntrance() {
        return this.uploadEntrance;
    }

    /* renamed from: a, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: a0, reason: from getter */
    public final String getUploadImageClientKey() {
        return this.uploadImageClientKey;
    }

    /* renamed from: b, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    /* renamed from: b0, reason: from getter */
    public final String getUploadPhotoComeFrom() {
        return this.uploadPhotoComeFrom;
    }

    /* renamed from: c, reason: from getter */
    public final String getAlbumCover() {
        return this.albumCover;
    }

    /* renamed from: c0, reason: from getter */
    public final Boolean getIsFromEventTag() {
        return this.isFromEventTag;
    }

    /* renamed from: d0, reason: from getter */
    public final Boolean getIsJumpReeditPublishFlow() {
        return this.isJumpReeditPublishFlow;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: e0, reason: from getter */
    public final Boolean getIsPhotoRepairByOpr() {
        return this.isPhotoRepairByOpr;
    }

    /* renamed from: f, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    /* renamed from: f0, reason: from getter */
    public final Boolean getIsShowNewCard() {
        return this.isShowNewCard;
    }

    /* renamed from: g, reason: from getter */
    public final String getDefaultText() {
        return this.defaultText;
    }

    /* renamed from: g0, reason: from getter */
    public final Boolean getIsTrimVideoBlackList() {
        return this.isTrimVideoBlackList;
    }

    public final String getTitle() {
        return this.title;
    }

    /* renamed from: h0, reason: from getter */
    public final Boolean getIsUploadVideo() {
        return this.isUploadVideo;
    }

    public final void i0(String str) {
        this.action = str;
    }

    /* renamed from: j, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final void j0(String str) {
        this.adId = str;
    }

    /* renamed from: k, reason: from getter */
    public final Boolean getEnterByLongClick() {
        return this.enterByLongClick;
    }

    public final void k0(String str) {
        this.albumCover = str;
    }

    /* renamed from: l, reason: from getter */
    public final long getEnterTime() {
        return this.enterTime;
    }

    public final void l0(String str) {
        this.albumId = str;
    }

    /* renamed from: m, reason: from getter */
    public final Bundle getExtraBundleInfo() {
        return this.extraBundleInfo;
    }

    public final void m0(String str) {
        this.albumName = str;
    }

    /* renamed from: n, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    public final void n0(String str) {
        this.defaultText = str;
    }

    /* renamed from: o, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public final void o0(Boolean bool) {
        this.enterByLongClick = bool;
    }

    /* renamed from: p, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    public final void p0(String str) {
        this.filePath = str;
    }

    /* renamed from: q, reason: from getter */
    public final Boolean getHideAddBtn() {
        return this.hideAddBtn;
    }

    public final void q0(Boolean bool) {
        this.isFromEventTag = bool;
    }

    /* renamed from: r, reason: from getter */
    public final Integer getKeyType() {
        return this.keyType;
    }

    public final void r0(Boolean bool) {
        this.hideAddBtn = bool;
    }

    /* renamed from: s, reason: from getter */
    public final Boolean getNeedJumpToEditPage() {
        return this.needJumpToEditPage;
    }

    public final void s0(Boolean bool) {
        this.isJumpReeditPublishFlow = bool;
    }

    /* renamed from: t, reason: from getter */
    public final Boolean getNeedLoadPhotoFromIntent() {
        return this.needLoadPhotoFromIntent;
    }

    public final void t0(Integer num) {
        this.keyType = num;
    }

    /* renamed from: u, reason: from getter */
    public final Boolean getNeedSaveDraft() {
        return this.needSaveDraft;
    }

    public final void u0(Boolean bool) {
        this.needJumpToEditPage = bool;
    }

    /* renamed from: v, reason: from getter */
    public final Integer getOperateType() {
        return this.operateType;
    }

    public final void v0(Boolean bool) {
        this.needLoadPhotoFromIntent = bool;
    }

    public final ArrayList<String> w() {
        return this.photoPaths;
    }

    public final void w0(Boolean bool) {
        this.needSaveDraft = bool;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.enterTime);
        parcel.writeValue(this.startUpSceneId);
        parcel.writeString(this.action);
        parcel.writeValue(this.isUploadVideo);
        parcel.writeValue(this.keyType);
        parcel.writeValue(this.needLoadPhotoFromIntent);
        parcel.writeValue(this.uploadEntrance);
        parcel.writeValue(this.isShowNewCard);
        parcel.writeString(this.adId);
        parcel.writeString(this.tagTitle);
        parcel.writeString(this.tagUin);
        parcel.writeString(this.tagProtocol);
        parcel.writeParcelable(this.tagBean, flags);
        parcel.writeString(this.refer);
        parcel.writeValue(this.isFromEventTag);
        parcel.writeStringList(this.photoPaths);
        parcel.writeValue(this.needJumpToEditPage);
        parcel.writeValue(this.operateType);
        parcel.writeValue(this.needSaveDraft);
        parcel.writeValue(this.isJumpReeditPublishFlow);
        parcel.writeString(this.defaultText);
        parcel.writeValue(this.isTrimVideoBlackList);
        parcel.writeString(this.qzoneUin);
        parcel.writeString(this.qzoneNickname);
        parcel.writeString(this.filePath);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeValue(this.hideAddBtn);
        parcel.writeValue(this.stateType);
        parcel.writeString(this.albumId);
        parcel.writeString(this.albumName);
        parcel.writeString(this.albumCover);
        parcel.writeString(this.uploadImageClientKey);
        parcel.writeString(this.uploadPhotoComeFrom);
        parcel.writeString(this.groupId);
        parcel.writeString(this.groupName);
        parcel.writeStringList(this.selectedImagePathList);
        parcel.writeString(this.repairSrTaskId);
        parcel.writeString(this.repairSrUrl);
        parcel.writeValue(this.isPhotoRepairByOpr);
        parcel.writeValue(this.enterByLongClick);
        parcel.writeBundle(this.extraBundleInfo);
    }

    /* renamed from: x, reason: from getter */
    public final String getQzoneNickname() {
        return this.qzoneNickname;
    }

    public final void x0(Integer num) {
        this.operateType = num;
    }

    /* renamed from: y, reason: from getter */
    public final String getQzoneUin() {
        return this.qzoneUin;
    }

    public final void y0(ArrayList<String> arrayList) {
        this.photoPaths = arrayList;
    }

    /* renamed from: z, reason: from getter */
    public final String getRefer() {
        return this.refer;
    }

    public final void z0(Boolean bool) {
        this.isPhotoRepairByOpr = bool;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZonePublishMoodInitBean(Parcel parcel) {
        this(parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Class cls = Integer.TYPE;
        Object readValue = parcel.readValue(cls.getClassLoader());
        this.startUpSceneId = readValue instanceof Integer ? (Integer) readValue : null;
        this.action = parcel.readString();
        Class cls2 = Boolean.TYPE;
        Object readValue2 = parcel.readValue(cls2.getClassLoader());
        this.isUploadVideo = readValue2 instanceof Boolean ? (Boolean) readValue2 : null;
        Object readValue3 = parcel.readValue(cls.getClassLoader());
        this.keyType = readValue3 instanceof Integer ? (Integer) readValue3 : null;
        Object readValue4 = parcel.readValue(cls2.getClassLoader());
        this.needLoadPhotoFromIntent = readValue4 instanceof Boolean ? (Boolean) readValue4 : null;
        Object readValue5 = parcel.readValue(cls.getClassLoader());
        this.uploadEntrance = readValue5 instanceof Integer ? (Integer) readValue5 : null;
        Object readValue6 = parcel.readValue(cls2.getClassLoader());
        this.isShowNewCard = readValue6 instanceof Boolean ? (Boolean) readValue6 : null;
        this.adId = parcel.readString();
        this.tagTitle = parcel.readString();
        this.tagUin = parcel.readString();
        this.tagProtocol = parcel.readString();
        this.tagBean = (QZonePublishTagBean) parcel.readParcelable(QZonePublishTagBean.class.getClassLoader());
        this.refer = parcel.readString();
        Object readValue7 = parcel.readValue(cls2.getClassLoader());
        this.isFromEventTag = readValue7 instanceof Boolean ? (Boolean) readValue7 : null;
        this.photoPaths = parcel.createStringArrayList();
        Object readValue8 = parcel.readValue(cls2.getClassLoader());
        this.needJumpToEditPage = readValue8 instanceof Boolean ? (Boolean) readValue8 : null;
        Object readValue9 = parcel.readValue(cls.getClassLoader());
        this.operateType = readValue9 instanceof Integer ? (Integer) readValue9 : null;
        Object readValue10 = parcel.readValue(cls2.getClassLoader());
        this.needSaveDraft = readValue10 instanceof Boolean ? (Boolean) readValue10 : null;
        Object readValue11 = parcel.readValue(cls2.getClassLoader());
        this.isJumpReeditPublishFlow = readValue11 instanceof Boolean ? (Boolean) readValue11 : null;
        this.defaultText = parcel.readString();
        Object readValue12 = parcel.readValue(cls2.getClassLoader());
        this.isTrimVideoBlackList = readValue12 instanceof Boolean ? (Boolean) readValue12 : null;
        this.qzoneUin = parcel.readString();
        this.qzoneNickname = parcel.readString();
        this.filePath = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        Object readValue13 = parcel.readValue(cls2.getClassLoader());
        this.hideAddBtn = readValue13 instanceof Boolean ? (Boolean) readValue13 : null;
        Object readValue14 = parcel.readValue(cls.getClassLoader());
        this.stateType = readValue14 instanceof Integer ? (Integer) readValue14 : null;
        this.albumId = parcel.readString();
        this.albumName = parcel.readString();
        this.albumCover = parcel.readString();
        this.uploadImageClientKey = parcel.readString();
        this.uploadPhotoComeFrom = parcel.readString();
        this.groupId = parcel.readString();
        this.groupName = parcel.readString();
        this.selectedImagePathList = parcel.createStringArrayList();
        this.repairSrTaskId = parcel.readString();
        this.repairSrUrl = parcel.readString();
        Object readValue15 = parcel.readValue(cls2.getClassLoader());
        this.isPhotoRepairByOpr = readValue15 instanceof Boolean ? (Boolean) readValue15 : null;
        Object readValue16 = parcel.readValue(cls2.getClassLoader());
        this.enterByLongClick = readValue16 instanceof Boolean ? (Boolean) readValue16 : null;
        Bundle readBundle = parcel.readBundle();
        Intrinsics.checkNotNull(readBundle);
        this.extraBundleInfo = readBundle;
    }
}
