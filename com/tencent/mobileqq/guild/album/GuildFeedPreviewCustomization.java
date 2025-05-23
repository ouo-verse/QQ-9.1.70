package com.tencent.mobileqq.guild.album;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.album.a;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 3*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u00014B\u001d\u0012\u0006\u0010.\u001a\u00020-\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u000bH\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\bH\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010+\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/album/GuildFeedPreviewCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/preview/PreviewCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "updateMagicStick", "", "needShowToast", AppConstants.Key.COLUMN_IS_VALID, "", "flag", "updateSendBtnUI", "updateSelectableUI", "asyncParseImage", "hasQrCode", "runOnUIHandler", "onSelectFinish", "Landroid/content/Intent;", "getIntent", "getSelectState", "getCurPhotoNum", "getCurVideoNum", "intent", "initData", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getBottomView", "position", "onGalleryItemSelected", "onSendClick", "needGestureUp", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "progressDialog", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "maxSelectPhotoNum", "I", "maxSelectVideoNum", "needMutexMedia", "Z", "checkQrCode", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "Companion", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildFeedPreviewCustomization<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends PreviewCustomizationBase<O> {
    public static final int DEFAULT_CHOOSE_VIDEO_DURATION = 1200000;
    public static final long DEFAULT_CHOOSE_VIDEO_MAX_SIZE = 1610612736;
    private static final String GIF_PRX = "gif";
    private static final String TAG = "GuildFeedPreviewCustomization";
    private boolean checkQrCode;
    private int maxSelectPhotoNum;
    private int maxSelectVideoNum;
    private boolean needMutexMedia;
    private QQProgressDialog progressDialog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedPreviewCustomization(FragmentActivity activity, com.tencent.qqnt.qbasealbum.customization.common.b<O> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
    }

    private final void asyncParseImage() {
        if (this.progressDialog == null) {
            this.progressDialog = new QQProgressDialog(getActivity(), getActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        QQProgressDialog qQProgressDialog = this.progressDialog;
        if (qQProgressDialog != null) {
            qQProgressDialog.setMessage(R.string.f139090ab);
        }
        QQProgressDialog qQProgressDialog2 = this.progressDialog;
        if (qQProgressDialog2 != null) {
            qQProgressDialog2.setCancelable(false);
        }
        QQProgressDialog qQProgressDialog3 = this.progressDialog;
        if (qQProgressDialog3 != null) {
            qQProgressDialog3.show();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.album.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPreviewCustomization.asyncParseImage$lambda$3(GuildFeedPreviewCustomization.this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncParseImage$lambda$3(GuildFeedPreviewCustomization this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<LocalMediaInfo> it = this$0.getPhotoCommonData().h().iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            }
            LocalMediaInfo next = it.next();
            a.f214243a.e(next);
            if (this$0.checkQrCode && gg1.a.a(next.getPath())) {
                z16 = true;
                break;
            }
        }
        a.f214243a.f(this$0.getPhotoCommonData().h());
        this$0.runOnUIHandler(z16);
    }

    private final int getCurPhotoNum() {
        List<LocalMediaInfo> h16 = getPhotoCommonData().h();
        ArrayList arrayList = new ArrayList();
        for (Object obj : h16) {
            if (!(((LocalMediaInfo) obj).getMMediaType() == 1)) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    private final int getCurVideoNum() {
        return getPhotoCommonData().h().size() - getCurPhotoNum();
    }

    private final Intent getIntent() {
        Intent intent = getActivity().getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.putBoolean(PeakConstants.GUILD_ALBUM_QUALITY, getPhotoCommonData().j());
            AlbumResult albumResult = new AlbumResult();
            albumResult.o(new ArrayList(getPhotoCommonData().h()));
            albumResult.m(getPhotoCommonData().j());
            albumResult.j(getPhotoCommonData().b());
            Unit unit = Unit.INSTANCE;
            extras.putParcelable("ALBUM_RESULT", albumResult);
            intent.putExtras(extras);
        }
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return intent;
    }

    private final int getSelectState() {
        List<LocalMediaInfo> h16 = getPhotoCommonData().h();
        if (!h16.isEmpty()) {
            return a.f214243a.q(h16.get(0)) ? 1 : 2;
        }
        return 0;
    }

    private final boolean isValid(LocalMediaInfo mediaInfo, boolean needShowToast) {
        if (TextUtils.isEmpty(mediaInfo.getPath())) {
            QLog.e(TAG, 1, "onSelectClick path is empty");
            QQToastUtil.showQQToast(R.string.f144380om);
            return false;
        }
        if (mediaInfo.getMediaWidth() > 0 && mediaInfo.getMediaHeight() > 0) {
            String[] strArr = needShowToast ? null : new String[]{""};
            a aVar = a.f214243a;
            return aVar.q(mediaInfo) ? a.C7671a.f214244d.isValidImage(mediaInfo, strArr) == 0 : !aVar.r(mediaInfo) || a.C7671a.f214244d.isValidVideo(mediaInfo, strArr) == 0;
        }
        QLog.e(TAG, 1, "onSelectClick pic empty");
        QQToastUtil.showQQToast(R.string.f144380om);
        return false;
    }

    private final void onSelectFinish() {
        getActivity().setResult(-1, getIntent());
        getActivity().finish();
        QAlbumUtil.anim(getActivity(), false, false);
    }

    private final void runOnUIHandler(final boolean hasQrCode) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.album.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPreviewCustomization.runOnUIHandler$lambda$4(GuildFeedPreviewCustomization.this, hasQrCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnUIHandler$lambda$4(GuildFeedPreviewCustomization this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity().isFinishing() || this$0.getActivity().isDestroyed()) {
            return;
        }
        QQProgressDialog qQProgressDialog = this$0.progressDialog;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        if (z16) {
            ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptQrCodeSendToast();
        } else {
            this$0.onSelectFinish();
        }
    }

    private final void updateMagicStick(final LocalMediaInfo mediaInfo) {
        final CheckBox qualityCb;
        final TextView magicStickBtn = getMagicStickBtn();
        if (magicStickBtn == null || (qualityCb = getQualityCb()) == null) {
            return;
        }
        magicStickBtn.post(new Runnable() { // from class: com.tencent.mobileqq.guild.album.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPreviewCustomization.updateMagicStick$lambda$2(qualityCb, this, mediaInfo, magicStickBtn);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMagicStick$lambda$2(CheckBox qualityCb, GuildFeedPreviewCustomization this$0, LocalMediaInfo mediaInfo, TextView editBtn) {
        Intrinsics.checkNotNullParameter(qualityCb, "$qualityCb");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNullParameter(editBtn, "$editBtn");
        qualityCb.setTranslationX(0.0f);
        TextView qualityTv = this$0.getQualityTv();
        if (qualityTv != null) {
            qualityTv.setTranslationX(0.0f);
        }
        TextView qualitySize = this$0.getQualitySize();
        if (qualitySize != null) {
            qualitySize.setTranslationX(0.0f);
        }
        if (mediaInfo.getMMediaType() == 0) {
            editBtn.setVisibility(0);
            return;
        }
        editBtn.setVisibility(4);
        float left = editBtn.getLeft() - qualityCb.getLeft();
        qualityCb.setTranslationX(left);
        TextView qualityTv2 = this$0.getQualityTv();
        if (qualityTv2 != null) {
            qualityTv2.setTranslationX(left);
        }
        TextView qualitySize2 = this$0.getQualitySize();
        if (qualitySize2 == null) {
            return;
        }
        qualitySize2.setTranslationX(left);
    }

    private final void updateSelectableUI(int flag) {
        CheckBox selectedBox = getSelectedBox();
        if (selectedBox != null) {
            selectedBox.setVisibility(flag);
        }
        CheckBox qualityCb = getQualityCb();
        if (qualityCb != null) {
            qualityCb.setVisibility(flag);
        }
        TextView qualityTv = getQualityTv();
        if (qualityTv != null) {
            qualityTv.setVisibility(flag);
        }
        TextView qualitySize = getQualitySize();
        if (qualitySize != null) {
            qualitySize.setVisibility(flag);
        }
        CheckBox selectedBox2 = getSelectedBox();
        if (selectedBox2 != null) {
            selectedBox2.setClickable(flag == 0);
        }
        CheckBox qualityCb2 = getQualityCb();
        if (qualityCb2 == null) {
            return;
        }
        qualityCb2.setClickable(flag == 0);
    }

    private final void updateSendBtnUI(int flag) {
        Button sendBtn = getSendBtn();
        if (sendBtn == null) {
            return;
        }
        sendBtn.setVisibility(flag);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.a
    public View getBottomView(Context context, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View bottomView = super.getBottomView(context, parent);
        Button sendBtn = getSendBtn();
        if (sendBtn != null) {
            sendBtn.setText(R.string.b9f);
        }
        return bottomView;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void initData(Intent intent) {
        super.initData(intent);
        if (intent != null) {
            this.maxSelectPhotoNum = intent.getIntExtra("key_guild_feed_publish_max_photo", 9);
            this.needMutexMedia = intent.getBooleanExtra("key_guild_feed_need_mutex_media", false);
            this.checkQrCode = intent.getBooleanExtra("key_guild_check_qrcode_image", false);
            this.maxSelectVideoNum = intent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.a
    public boolean needGestureUp() {
        return false;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onGalleryItemSelected(LocalMediaInfo mediaInfo, int position) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        updateMagicStick(mediaInfo);
        updateSelectableUI(0);
        updateSendBtnUI(0);
        int selectState = getSelectState();
        int p16 = a.f214243a.p(mediaInfo);
        if (this.needMutexMedia && selectState != 0 && selectState != p16) {
            updateSelectableUI(4);
            return;
        }
        if (p16 != 1) {
            if (p16 == 2 && getCurVideoNum() >= this.maxSelectVideoNum && mediaInfo.getSelectStatus() != 1) {
                updateSelectableUI(4);
            }
        } else if (getCurPhotoNum() >= this.maxSelectPhotoNum && mediaInfo.getSelectStatus() != 1) {
            updateSelectableUI(4);
        }
        if (!isValid(mediaInfo, true)) {
            updateSendBtnUI(4);
            updateSelectableUI(4);
        }
        super.onGalleryItemSelected(mediaInfo, position);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onSendClick() {
        asyncParseImage();
    }

    static /* synthetic */ boolean isValid$default(GuildFeedPreviewCustomization guildFeedPreviewCustomization, LocalMediaInfo localMediaInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return guildFeedPreviewCustomization.isValid(localMediaInfo, z16);
    }
}
