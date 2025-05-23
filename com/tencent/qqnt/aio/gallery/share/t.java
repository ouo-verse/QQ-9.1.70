package com.tencent.qqnt.aio.gallery.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.aio.data.AIOContact;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0010B\u0011\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u00a2\u0006\u0004\b#\u0010$J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J*\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016JB\u0010 \u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001f\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/t;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "j", "l", "", "g", "", "", "e", "", "c", "a", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "b", "k", "subId", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/h;", "provider", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", "mContext", "Landroid/content/Intent;", "intent", "templateId", "templateName", "action", "i", "Z", "isUseNewShare", "<init>", "(Z)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class t extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isUseNewShare;

    public t(boolean z16) {
        this.isUseNewShare = z16;
    }

    private final void j(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        if (shareContext.getMsgRecord() == null || shareContext.f() == null) {
            return;
        }
        int mediaType = shareContext.getMediaType();
        if (mediaType != 1) {
            if (mediaType != 2) {
                if (mediaType == 3) {
                    Pair<Long, Integer> f16 = shareContext.f();
                    Intrinsics.checkNotNull(f16);
                    m(shareContext, item, f16.getSecond().intValue(), shareContext.getProvider());
                    return;
                } else if (mediaType != 4) {
                    return;
                }
            }
            k(shareContext, item);
            return;
        }
        l(shareContext, item);
    }

    private final void l(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        if (TextUtils.isEmpty(shareContext.getExistSaveOrEditPath())) {
            QLog.e("NTShareToFriendAction", 1, "shareNormalPic is empty");
            return;
        }
        Bundle bundle = new Bundle(shareContext.getActivity().getIntent().getExtras());
        bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
        RFWLayerPicInfo layerPicInfo = shareContext.getLayerItemInfo().getLayerPicInfo();
        if ((layerPicInfo != null ? layerPicInfo.getSmallPicInfo() : null) != null) {
            RFWLayerPicInfo layerPicInfo2 = shareContext.getLayerItemInfo().getLayerPicInfo();
            RFWLayerPicInfo.RFWPicInfo smallPicInfo = layerPicInfo2 != null ? layerPicInfo2.getSmallPicInfo() : null;
            Intrinsics.checkNotNull(smallPicInfo);
            if (RFWFileUtils.fileExists(smallPicInfo.getLocalPath())) {
                RFWLayerPicInfo layerPicInfo3 = shareContext.getLayerItemInfo().getLayerPicInfo();
                RFWLayerPicInfo.RFWPicInfo smallPicInfo2 = layerPicInfo3 != null ? layerPicInfo3.getSmallPicInfo() : null;
                Intrinsics.checkNotNull(smallPicInfo2);
                bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, new File(smallPicInfo2.getLocalPath()).toURI().toURL().toString());
            }
        }
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, new File(shareContext.getExistSaveOrEditPath()).toURI().toURL().toString());
        com.tencent.qqnt.aio.gallery.j jVar = com.tencent.qqnt.aio.gallery.j.f350008a;
        if (jVar.g(this.isUseNewShare, jVar.e(shareContext.getMediaType()))) {
            bundle.putBoolean(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
        }
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardPicToFriend(new File(shareContext.getExistSaveOrEditPath()), shareContext.getLayerItemInfo().isShowOriginPic(), shareContext.getAioLayerData(), bundle, shareContext.getActivity(), item != null ? item.action : 2, item != null ? item.uin : null, item != null ? item.uinType : 0, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "biz_src_jc_photo");
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void a(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        j(shareContext, null);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        j(shareContext, item);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<String> c() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("qqfriend");
        return listOf;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.FIRST;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return !TextUtils.isEmpty(shareContext.getExistSaveOrEditPath());
    }

    public final void k(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.FORWARD_NT_FROM_AIO_MSG, true);
        MsgRecord msgRecord = shareContext.getMsgRecord();
        Intrinsics.checkNotNull(msgRecord);
        intent.putExtra(AppConstants.Key.FORWARD_NT_MSG_ID, msgRecord.msgId);
        intent.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_UID, shareContext.getMsgRecord().peerUid);
        intent.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_CHATTYPE, shareContext.getMsgRecord().chatType);
        intent.putExtra(AppConstants.Key.FORWARD_FILE_SAVED_OREDIT, shareContext.getExistSaveOrEditPath());
        com.tencent.qqnt.aio.gallery.j jVar = com.tencent.qqnt.aio.gallery.j.f350008a;
        if (jVar.g(this.isUseNewShare, jVar.e(shareContext.getMediaType()))) {
            intent.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
        }
        AIOMsgItem aIOMsgItem = new AIOMsgItem(shareContext.getMsgRecord());
        boolean z16 = false;
        if (shareContext.f() != null) {
            Pair<Long, Integer> f16 = shareContext.f();
            Intrinsics.checkNotNull(f16);
            if (f16.getSecond().intValue() > 0) {
                Pair<Long, Integer> f17 = shareContext.f();
                intent.putExtra(AppConstants.Key.FORWARD_NT_FILE_INDEX, f17 != null ? f17.getSecond().intValue() : 0);
            }
        }
        new com.tencent.qqnt.aio.forward.b().a(aIOMsgItem, new AIOContact(0, "", "", ""), intent);
        intent.putExtra("forward _key_nojump", false);
        com.tencent.qqnt.aio.forward.l.INSTANCE.a().l(aIOMsgItem);
        if (item != null && item.action == 72) {
            z16 = true;
        }
        if (z16) {
            intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
            intent.putExtra("key_direct_show_uin_type", item.uinType);
            intent.putExtra("key_direct_show_uin", item.uin);
            ForwardBaseOption.startForwardActivityForResult(shareContext.getActivity(), intent, (Class<?>) ForwardRecentTranslucentActivity.class, 19005, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, " biz_src_jc_video");
            return;
        }
        ForwardBaseOption.startForwardActivityForResult(shareContext.getActivity(), intent, 21);
    }

    public final void m(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item, int subId, com.tencent.qqnt.aio.adapter.richmedia.provider.h provider) {
        Intent intent;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (provider != null) {
            MsgRecord msgRecord = shareContext.getMsgRecord();
            Intrinsics.checkNotNull(msgRecord);
            intent = provider.h(msgRecord, subId, shareContext.getMsgRecord().elements.get(subId), shareContext.getMsgRecord().chatType);
        } else {
            intent = null;
        }
        Intent intent2 = intent;
        com.tencent.qqnt.aio.gallery.j jVar = com.tencent.qqnt.aio.gallery.j.f350008a;
        if (jVar.g(this.isUseNewShare, jVar.e(shareContext.getMediaType())) && intent2 != null) {
            intent2.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
        }
        if (intent2 != null) {
            i(shareContext.getActivity(), intent2, "", "", item != null ? item.action : 0, item);
        }
    }

    public /* synthetic */ t(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(2);
        return listOf;
    }

    public void i(Activity mContext, Intent intent, String templateId, String templateName, int action, ShareActionSheetBuilder.ActionSheetItem item) {
        if (intent != null) {
            if (!TextUtils.isEmpty(templateId)) {
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, templateId);
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, templateName);
            }
            if (action == 72) {
                intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                intent.putExtra("key_direct_show_uin_type", item != null ? Integer.valueOf(item.uinType) : null);
                intent.putExtra("key_direct_show_uin", item != null ? item.uin : null);
                ForwardBaseOption.startForwardActivityForResult(mContext, intent, (Class<?>) ForwardRecentTranslucentActivity.class, 19005, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, " biz_src_jc_video");
                return;
            }
            ForwardBaseOption.startForwardActivity(mContext, intent, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, " biz_src_jc_video");
        }
    }
}
