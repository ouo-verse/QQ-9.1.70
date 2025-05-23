package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.a;
import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u008d\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u001e\u0012\u0010\b\u0002\u0010\"\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\u0010\b\u0002\u00100\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\u0010\b\u0002\u00108\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`7\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u0012\u0010\b\u0002\u0010J\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`I\u00a2\u0006\u0004\bP\u0010QJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u001e\u0010\u001f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`!8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\rR\u0018\u0010+\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001e\u00100\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`/8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010 R\u0018\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001e\u00108\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`78\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010 R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\rR\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001e\u0010J\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`I8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010 R \u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020L0K8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010N\u00a8\u0006R"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "albumId", "Ljava/lang/String;", "owner", "name", "desc", "", WadlProxyConsts.CREATE_TIME, "Ljava/lang/Long;", "modifyTime", "lastUploadTime", "uploadNumber", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "cover", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "creator", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "topFlag", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumBusiType;", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "Ljava/lang/Integer;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumStatusType;", "status", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumAccessPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumAccessPermission;", "", "allowShare", "Ljava/lang/Boolean;", "isSubscribe", MimeHelper.IMAGE_SUBTYPE_BITMAP, "isShareAlbum", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ShareAlbumMeta;", "shareAlbum", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ShareAlbumMeta;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QzoneAlbumType;", "qzAlbumType", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/FamilyAlbumMeta;", "familyAlbum", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/FamilyAlbumMeta;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/LoverAlbumMeta;", "loverAlbum", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/LoverAlbumMeta;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumCoverTypeEnum;", "coverType", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/TravelAlbumMeta;", "travelAlbum", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/TravelAlbumMeta;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellVisitor;", "visitorInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellVisitor;", "defaultDesc", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumOpInfo;", "opInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumOpInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ActiveAlbumInfo;", "activeAlbum", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ActiveAlbumInfo;", "Lc45/a;", "marketingAlbum", "Lc45/a;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/MediaSortType;", "sortType", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumAccessPermission;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ShareAlbumMeta;Ljava/lang/Integer;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/FamilyAlbumMeta;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/LoverAlbumMeta;Ljava/lang/Integer;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/TravelAlbumMeta;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellVisitor;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumOpInfo;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ActiveAlbumInfo;Lc45/a;Ljava/lang/Integer;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class AlbumInfo extends j {
    public static final int $stable = 8;
    public ActiveAlbumInfo activeAlbum;
    public String albumId;
    public Boolean allowShare;
    public String bitmap;
    public Integer busiType;
    public StMedia cover;
    public Integer coverType;
    public Long createTime;
    public StUser creator;
    public String defaultDesc;
    public String desc;
    public FamilyAlbumMeta familyAlbum;
    public Boolean isShareAlbum;
    public Boolean isSubscribe;
    public Long lastUploadTime;
    public LoverAlbumMeta loverAlbum;
    public a marketingAlbum;
    public Long modifyTime;
    public String name;
    public AlbumOpInfo opInfo;
    public String owner;
    public AlbumAccessPermission permission;
    public Integer qzAlbumType;
    public ShareAlbumMeta shareAlbum;
    public Integer sortType;
    public Integer status;
    public Long topFlag;
    public TravelAlbumMeta travelAlbum;
    public Long uploadNumber;
    public StFeedCellVisitor visitorInfo;

    public AlbumInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        Boolean bool = null;
        return u16.g(new AlbumInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, null, bool, bool, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.albumId = (String) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.owner = (String) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.name = (String) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.desc = (String) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.createTime = (Long) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.modifyTime = (Long) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.lastUploadTime = (Long) v3;
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.uploadNumber = (Long) v3;
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia");
                this.cover = (StMedia) v3;
                return;
            case 10:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser");
                this.creator = (StUser) v3;
                return;
            case 11:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.topFlag = (Long) v3;
                return;
            case 12:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Album_metaKt.AlbumBusiType }");
                this.busiType = (Integer) v3;
                return;
            case 13:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Album_metaKt.AlbumStatusType }");
                this.status = (Integer) v3;
                return;
            case 14:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumAccessPermission");
                this.permission = (AlbumAccessPermission) v3;
                return;
            case 15:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.allowShare = (Boolean) v3;
                return;
            case 16:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.isSubscribe = (Boolean) v3;
                return;
            case 17:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.bitmap = (String) v3;
                return;
            case 18:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.isShareAlbum = (Boolean) v3;
                return;
            case 19:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.ShareAlbumMeta");
                this.shareAlbum = (ShareAlbumMeta) v3;
                return;
            case 20:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Album_metaKt.QzoneAlbumType }");
                this.qzAlbumType = (Integer) v3;
                return;
            case 21:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.FamilyAlbumMeta");
                this.familyAlbum = (FamilyAlbumMeta) v3;
                return;
            case 22:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.LoverAlbumMeta");
                this.loverAlbum = (LoverAlbumMeta) v3;
                return;
            case 23:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Album_metaKt.AlbumCoverTypeEnum }");
                this.coverType = (Integer) v3;
                return;
            case 24:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.TravelAlbumMeta");
                this.travelAlbum = (TravelAlbumMeta) v3;
                return;
            case 25:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellVisitor");
                this.visitorInfo = (StFeedCellVisitor) v3;
                return;
            case 26:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.defaultDesc = (String) v3;
                return;
            case 27:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumOpInfo");
                this.opInfo = (AlbumOpInfo) v3;
                return;
            case 28:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.ActiveAlbumInfo");
                this.activeAlbum = (ActiveAlbumInfo) v3;
                return;
            case 29:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type pbandk.ByteArr");
                this.marketingAlbum = (a) v3;
                return;
            case 30:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MetaKt.MediaSortType }");
                this.sortType = (Integer) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ AlbumInfo(String str, String str2, String str3, String str4, Long l3, Long l16, Long l17, Long l18, StMedia stMedia, StUser stUser, Long l19, Integer num, Integer num2, AlbumAccessPermission albumAccessPermission, Boolean bool, Boolean bool2, String str5, Boolean bool3, ShareAlbumMeta shareAlbumMeta, Integer num3, FamilyAlbumMeta familyAlbumMeta, LoverAlbumMeta loverAlbumMeta, Integer num4, TravelAlbumMeta travelAlbumMeta, StFeedCellVisitor stFeedCellVisitor, String str6, AlbumOpInfo albumOpInfo, ActiveAlbumInfo activeAlbumInfo, a aVar, Integer num5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : l3, (i3 & 32) != 0 ? null : l16, (i3 & 64) != 0 ? null : l17, (i3 & 128) != 0 ? null : l18, (i3 & 256) != 0 ? null : stMedia, (i3 & 512) != 0 ? null : stUser, (i3 & 1024) != 0 ? null : l19, (i3 & 2048) != 0 ? null : num, (i3 & 4096) != 0 ? null : num2, (i3 & 8192) != 0 ? null : albumAccessPermission, (i3 & 16384) != 0 ? null : bool, (i3 & 32768) != 0 ? null : bool2, (i3 & 65536) != 0 ? null : str5, (i3 & 131072) != 0 ? null : bool3, (i3 & 262144) != 0 ? null : shareAlbumMeta, (i3 & 524288) != 0 ? null : num3, (i3 & 1048576) != 0 ? null : familyAlbumMeta, (i3 & 2097152) != 0 ? null : loverAlbumMeta, (i3 & 4194304) != 0 ? null : num4, (i3 & 8388608) != 0 ? null : travelAlbumMeta, (i3 & 16777216) != 0 ? null : stFeedCellVisitor, (i3 & 33554432) != 0 ? null : str6, (i3 & 67108864) != 0 ? null : albumOpInfo, (i3 & 134217728) != 0 ? null : activeAlbumInfo, (i3 & 268435456) != 0 ? null : aVar, (i3 & 536870912) != 0 ? null : num5);
    }

    public AlbumInfo(String str, String str2, String str3, String str4, Long l3, Long l16, Long l17, Long l18, StMedia stMedia, StUser stUser, Long l19, Integer num, Integer num2, AlbumAccessPermission albumAccessPermission, Boolean bool, Boolean bool2, String str5, Boolean bool3, ShareAlbumMeta shareAlbumMeta, Integer num3, FamilyAlbumMeta familyAlbumMeta, LoverAlbumMeta loverAlbumMeta, Integer num4, TravelAlbumMeta travelAlbumMeta, StFeedCellVisitor stFeedCellVisitor, String str6, AlbumOpInfo albumOpInfo, ActiveAlbumInfo activeAlbumInfo, a aVar, Integer num5) {
        this.albumId = str;
        this.owner = str2;
        this.name = str3;
        this.desc = str4;
        this.createTime = l3;
        this.modifyTime = l16;
        this.lastUploadTime = l17;
        this.uploadNumber = l18;
        this.cover = stMedia;
        this.creator = stUser;
        this.topFlag = l19;
        this.busiType = num;
        this.status = num2;
        this.permission = albumAccessPermission;
        this.allowShare = bool;
        this.isSubscribe = bool2;
        this.bitmap = str5;
        this.isShareAlbum = bool3;
        this.shareAlbum = shareAlbumMeta;
        this.qzAlbumType = num3;
        this.familyAlbum = familyAlbumMeta;
        this.loverAlbum = loverAlbumMeta;
        this.coverType = num4;
        this.travelAlbum = travelAlbumMeta;
        this.visitorInfo = stFeedCellVisitor;
        this.defaultDesc = str6;
        this.opInfo = albumOpInfo;
        this.activeAlbum = activeAlbumInfo;
        this.marketingAlbum = aVar;
        this.sortType = num5;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        StMedia stMedia = this.cover;
        byte b16 = 0 == true ? 1 : 0;
        StUser stUser = this.creator;
        byte b17 = 0 == true ? 1 : 0;
        byte b18 = 0 == true ? 1 : 0;
        byte b19 = 0 == true ? 1 : 0;
        byte b26 = 0 == true ? 1 : 0;
        byte b27 = 0 == true ? 1 : 0;
        byte b28 = 0 == true ? 1 : 0;
        byte b29 = 0 == true ? 1 : 0;
        byte b36 = 0 == true ? 1 : 0;
        byte b37 = 0 == true ? 1 : 0;
        byte b38 = 0 == true ? 1 : 0;
        byte b39 = 0 == true ? 1 : 0;
        byte b46 = 0 == true ? 1 : 0;
        byte b47 = 0 == true ? 1 : 0;
        byte b48 = 0 == true ? 1 : 0;
        byte b49 = 0 == true ? 1 : 0;
        AlbumAccessPermission albumAccessPermission = this.permission;
        byte b56 = 0 == true ? 1 : 0;
        byte b57 = 0 == true ? 1 : 0;
        byte b58 = 0 == true ? 1 : 0;
        byte b59 = 0 == true ? 1 : 0;
        ShareAlbumMeta shareAlbumMeta = this.shareAlbum;
        byte b65 = 0 == true ? 1 : 0;
        byte b66 = 0 == true ? 1 : 0;
        byte b67 = 0 == true ? 1 : 0;
        LoverAlbumMeta loverAlbumMeta = this.loverAlbum;
        byte b68 = 0 == true ? 1 : 0;
        byte b69 = 0 == true ? 1 : 0;
        byte b75 = 0 == true ? 1 : 0;
        TravelAlbumMeta travelAlbumMeta = this.travelAlbum;
        byte b76 = 0 == true ? 1 : 0;
        byte b77 = 0 == true ? 1 : 0;
        StFeedCellVisitor stFeedCellVisitor = this.visitorInfo;
        int i3 = 15;
        DefaultConstructorMarker defaultConstructorMarker = null;
        byte b78 = 0 == true ? 1 : 0;
        byte b79 = 0 == true ? 1 : 0;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.albumId, new b.e.g(true))), TuplesKt.to(2, new h(2, this.owner, new b.e.g(true))), TuplesKt.to(3, new h(3, this.name, new b.e.g(true))), TuplesKt.to(4, new h(4, this.desc, new b.e.g(true))), TuplesKt.to(5, new h(5, this.createTime, new b.e.i(true))), TuplesKt.to(6, new h(6, this.modifyTime, new b.e.i(true))), TuplesKt.to(7, new h(7, this.lastUploadTime, new b.e.i(true))), TuplesKt.to(8, new h(8, this.uploadNumber, new b.e.i(true))), TuplesKt.to(9, new h(9, stMedia, new b.d(new StMedia(null, null, null, b16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null)))), TuplesKt.to(10, new h(10, stUser, new b.d(new StUser(null, b17, b18, b19, b26, b27, b28, b29, b36, b37, b38, b39, b46, b47, b48, b49, 65535, 0 == true ? 1 : 0)))), TuplesKt.to(11, new h(11, this.topFlag, new b.e.i(true))), TuplesKt.to(12, new h(12, this.busiType, new b.a(false))), TuplesKt.to(13, new h(13, this.status, new b.a(false))), TuplesKt.to(14, new h(14, albumAccessPermission, new b.d(new AlbumAccessPermission(null, b59, b56, b57, 15, b58)))), TuplesKt.to(15, new h(15, this.allowShare, new b.e.a(true))), TuplesKt.to(16, new h(16, this.isSubscribe, new b.e.a(true))), TuplesKt.to(17, new h(17, this.bitmap, new b.e.g(true))), TuplesKt.to(18, new h(18, this.isShareAlbum, new b.e.a(true))), TuplesKt.to(19, new h(19, shareAlbumMeta, new b.d(new ShareAlbumMeta(null, b67, b66, b65, 15, null)))), TuplesKt.to(20, new h(20, this.qzAlbumType, new b.a(false))), TuplesKt.to(21, new h(21, this.familyAlbum, new b.d(new FamilyAlbumMeta(null, 1, 0 == true ? 1 : 0)))), TuplesKt.to(22, new h(22, loverAlbumMeta, new b.d(new LoverAlbumMeta(null, b75, b69, 7, b68)))), TuplesKt.to(23, new h(23, this.coverType, new b.a(false))), TuplesKt.to(24, new h(24, travelAlbumMeta, new b.d(new TravelAlbumMeta(b76, b77, 3, 0 == true ? 1 : 0)))), TuplesKt.to(25, new h(25, stFeedCellVisitor, new b.d(new StFeedCellVisitor(0 == true ? 1 : 0, b79, b78, null, i3, defaultConstructorMarker)))), TuplesKt.to(26, new h(26, this.defaultDesc, new b.e.g(true))), TuplesKt.to(27, new h(27, this.opInfo, new b.d(new AlbumOpInfo(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, i3, defaultConstructorMarker)))), TuplesKt.to(28, new h(28, this.activeAlbum, new b.d(new ActiveAlbumInfo(0 == true ? 1 : 0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))), TuplesKt.to(29, new h(29, this.marketingAlbum, new b.e.C0167b(true))), TuplesKt.to(30, new h(30, this.sortType, new b.a(false))));
        return mapOf;
    }
}
