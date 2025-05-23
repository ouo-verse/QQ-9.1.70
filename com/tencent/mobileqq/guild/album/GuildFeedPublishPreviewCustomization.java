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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.album.a;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ue1.a;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 K*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001LB\u001d\u0012\u0006\u0010F\u001a\u00020E\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000G\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010!\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0018H\u0016J\u001a\u0010%\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0006H\u0016J\u0018\u0010'\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0006H\u0016J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0006H\u0016J\"\u0010,\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016R\u0016\u0010.\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010/R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u0004048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010:R$\u0010A\u001a\u0012\u0012\u0004\u0012\u00020=0<j\b\u0012\u0004\u0012\u00020=`>8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020\u00188BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010C\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/album/GuildFeedPublishPreviewCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/preview/PreviewCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "canSelectInCurState", "", "doRebindView", "needShowToast", AppConstants.Key.COLUMN_IS_VALID, "canSend", "updateSendBtnUI", "updateSelectableUI", "updateMagicStick", "Landroid/view/View;", "sendBtn", "onAlbumPreviewSendBtnClick", "doSend", "runOnUIHandler", "onSelectFinish", "Landroid/content/Intent;", "getIntent", "", "getCurPhotoNum", "getCurVideoNum", "intent", "initData", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getBottomView", "position", "onGalleryItemSelected", "isSelect", "onCurrentSelectStatusChangeEvent", "isChecked", "onQualityRawChangeEvent", "checkQualityRawChange", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "needGestureUp", "maxSelectPhotoNum", "I", "maxSelectVideoNum", "", "sendBtnText", "Ljava/lang/String;", "", "getSelectedMediaList", "()Ljava/util/List;", "selectedMediaList", "Lue1/a;", "getPublishCommonData", "()Lue1/a;", "publishCommonData", "Ljava/util/ArrayList;", "Lue1/a$b;", "Lkotlin/collections/ArrayList;", "getMediaHandleList", "()Ljava/util/ArrayList;", "mediaHandleList", "getSelectState", "()I", "selectState", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "Companion", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildFeedPublishPreviewCustomization<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends PreviewCustomizationBase<O> {
    private static final String TAG = "GuildFeedPreviewCustomization";
    private int maxSelectPhotoNum;
    private int maxSelectVideoNum;
    private String sendBtnText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedPublishPreviewCustomization(FragmentActivity activity, com.tencent.qqnt.qbasealbum.customization.common.b<O> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        this.sendBtnText = "";
    }

    private final boolean canSelectInCurState(LocalMediaInfo mediaInfo) {
        return getSelectState() == 0 || getSelectState() == mediaInfo.getMMediaType() + 1;
    }

    private final void doRebindView(LocalMediaInfo mediaInfo) {
        updateSelectableUI(mediaInfo);
        getPublishCommonData().t();
    }

    private final void doSend() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.album.k
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPublishPreviewCustomization.doSend$lambda$10(GuildFeedPublishPreviewCustomization.this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doSend$lambda$10(GuildFeedPublishPreviewCustomization this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<LocalMediaInfo> it = this$0.getSelectedMediaList().iterator();
        while (it.hasNext()) {
            a.f214243a.e(it.next());
        }
        a.f214243a.f(this$0.getSelectedMediaList());
        this$0.runOnUIHandler();
    }

    private final int getCurPhotoNum() {
        if (getSelectState() != 1) {
            return 0;
        }
        return getMediaHandleList().size();
    }

    private final int getCurVideoNum() {
        if (getSelectState() != 2) {
            return 0;
        }
        return getMediaHandleList().size();
    }

    private final Intent getIntent() {
        Intent intent = getActivity().getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.putBoolean(PeakConstants.GUILD_ALBUM_QUALITY, getPhotoCommonData().j());
            AlbumResult albumResult = new AlbumResult();
            albumResult.o(getPublishCommonData().m(getSelectedMediaList()));
            albumResult.m(getPhotoCommonData().j());
            albumResult.j(getPhotoCommonData().b());
            Unit unit = Unit.INSTANCE;
            extras.putParcelable("ALBUM_RESULT", albumResult);
            intent.putExtras(extras);
        }
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return intent;
    }

    private final ArrayList<a.MediaHandle> getMediaHandleList() {
        return getPublishCommonData().f();
    }

    private final ue1.a getPublishCommonData() {
        O otherCommonData = getOtherCommonData();
        Intrinsics.checkNotNull(otherCommonData, "null cannot be cast to non-null type com.tencent.mobileqq.guild.album.otherdata.GuildFeedPublishOtherCommonData");
        return (ue1.a) otherCommonData;
    }

    private final int getSelectState() {
        return getPublishCommonData().get_selectState();
    }

    private final List<LocalMediaInfo> getSelectedMediaList() {
        return getPhotoCommonData().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGalleryItemSelected$lambda$3(GuildFeedPublishPreviewCustomization this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onAlbumPreviewSendBtnClick(this$0.getSendBtn());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void onSelectFinish() {
        getActivity().setResult(-1, getIntent());
        getActivity().finish();
        QAlbumUtil.anim(getActivity(), false, false);
    }

    private final void runOnUIHandler() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.album.o
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPublishPreviewCustomization.runOnUIHandler$lambda$11(GuildFeedPublishPreviewCustomization.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnUIHandler$lambda$11(GuildFeedPublishPreviewCustomization this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity().isFinishing() || this$0.getActivity().isDestroyed()) {
            return;
        }
        this$0.onSelectFinish();
    }

    private final void updateMagicStick(final LocalMediaInfo mediaInfo) {
        final CheckBox qualityCb;
        final TextView magicStickBtn = getMagicStickBtn();
        if (magicStickBtn == null || (qualityCb = getQualityCb()) == null) {
            return;
        }
        magicStickBtn.post(new Runnable() { // from class: com.tencent.mobileqq.guild.album.j
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPublishPreviewCustomization.updateMagicStick$lambda$8(qualityCb, this, mediaInfo, magicStickBtn);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMagicStick$lambda$8(CheckBox qualityCb, GuildFeedPublishPreviewCustomization this$0, LocalMediaInfo mediaInfo, TextView editBtn) {
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

    private final void updateSelectableUI(final LocalMediaInfo mediaInfo) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (getSelectState() != 0 && !canSelectInCurState(mediaInfo)) {
            booleanRef.element = false;
        } else {
            int selectState = getSelectState();
            if (selectState != 1) {
                if (selectState == 2 && getCurVideoNum() >= this.maxSelectVideoNum && mediaInfo.getSelectStatus() != 1) {
                    booleanRef.element = false;
                }
            } else if (getCurPhotoNum() >= this.maxSelectPhotoNum && mediaInfo.getSelectStatus() != 1) {
                booleanRef.element = false;
            }
        }
        if (!isValid$default(this, mediaInfo, false, 2, null)) {
            booleanRef.element = false;
        }
        final CheckBox selectedBox = getSelectedBox();
        if (selectedBox != null) {
            selectedBox.post(new Runnable() { // from class: com.tencent.mobileqq.guild.album.p
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedPublishPreviewCustomization.updateSelectableUI$lambda$7$lambda$6(selectedBox, booleanRef, this, mediaInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSelectableUI$lambda$7$lambda$6(CheckBox this_apply, Ref.BooleanRef canSelect, GuildFeedPublishPreviewCustomization this$0, LocalMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(canSelect, "$canSelect");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        this_apply.setVisibility(canSelect.element ? 0 : 8);
        this_apply.setClickable(canSelect.element);
        int d16 = this$0.getPublishCommonData().d(mediaInfo) + 1;
        boolean z16 = this_apply.getVisibility() == 0 && d16 > 0;
        if (!z16 && canSelect.element) {
            this_apply.setChecked(false);
            return;
        }
        this_apply.setChecked(true);
        this_apply.setTextSize(2, 14.0f);
        this_apply.setText(String.valueOf(d16));
        QLog.i(TAG, 2, "[updateSelectableUI]--selectNumber:" + d16 + ",isSelect:" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSendBtnUI(final boolean canSend) {
        final Button sendBtn = getSendBtn();
        if (sendBtn != null && sendBtn.getVisibility() == 0) {
            sendBtn.post(new Runnable() { // from class: com.tencent.mobileqq.guild.album.n
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedPublishPreviewCustomization.updateSendBtnUI$lambda$5$lambda$4(GuildFeedPublishPreviewCustomization.this, sendBtn, canSend);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSendBtnUI$lambda$5$lambda$4(GuildFeedPublishPreviewCustomization this$0, Button this_apply, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (!this$0.getMediaHandleList().isEmpty()) {
            str = "(" + this$0.getMediaHandleList().size() + ")";
        } else {
            str = "";
        }
        this_apply.setText(this$0.sendBtnText + str);
        QLog.i(TAG, 2, "[updateSendBtnUI]--count:" + str + ",canSend:" + z16);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public boolean checkQualityRawChange(LocalMediaInfo mediaInfo, boolean isChecked) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (isChecked && getSelectedMediaList().isEmpty()) {
            if (!isValid(mediaInfo, true)) {
                return false;
            }
            if (canSelectInCurState(mediaInfo)) {
                return true;
            }
            onQualityRawChangeEvent(mediaInfo, isChecked);
            com.tencent.qqnt.qbasealbum.album.b.h(getActivity()).W1(isChecked);
            return false;
        }
        return super.checkQualityRawChange(mediaInfo, isChecked);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.a
    public View getBottomView(Context context, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View bottomView = super.getBottomView(context, parent);
        String string = context.getString(R.string.b9f);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.finish)");
        this.sendBtnText = string;
        Button sendBtn = getSendBtn();
        if (sendBtn != null) {
            sendBtn.setText(this.sendBtnText);
        }
        return bottomView;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void initData(Intent intent) {
        super.initData(intent);
        if (intent != null) {
            this.maxSelectPhotoNum = intent.getIntExtra("key_guild_feed_publish_max_photo", 9);
            this.maxSelectVideoNum = intent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
        }
        LiveData<Boolean> h16 = getPublishCommonData().h();
        FragmentActivity activity = getActivity();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(this) { // from class: com.tencent.mobileqq.guild.album.GuildFeedPublishPreviewCustomization$initData$2
            final /* synthetic */ GuildFeedPublishPreviewCustomization<O> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                GuildFeedPublishPreviewCustomization<O> guildFeedPublishPreviewCustomization = this.this$0;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildFeedPublishPreviewCustomization.updateSendBtnUI(it.booleanValue());
            }
        };
        h16.observe(activity, new Observer() { // from class: com.tencent.mobileqq.guild.album.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedPublishPreviewCustomization.initData$lambda$1(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.a
    public boolean needGestureUp() {
        return false;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getPublishCommonData().p(getPhotoCommonData().c());
        LocalMediaInfo a16 = getPreviewData().a();
        if (a16 != null) {
            doRebindView(a16);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onCurrentSelectStatusChangeEvent(LocalMediaInfo mediaInfo, boolean isSelect) {
        super.onCurrentSelectStatusChangeEvent(mediaInfo, isSelect);
        if (mediaInfo == null) {
            return;
        }
        doRebindView(mediaInfo);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onGalleryItemSelected(LocalMediaInfo mediaInfo, int position) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        super.onGalleryItemSelected(mediaInfo, position);
        Button sendBtn = getSendBtn();
        if (sendBtn != null) {
            sendBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.album.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildFeedPublishPreviewCustomization.onGalleryItemSelected$lambda$3(GuildFeedPublishPreviewCustomization.this, view);
                }
            });
        }
        updateMagicStick(mediaInfo);
        doRebindView(mediaInfo);
        QLog.i(TAG, 2, "[onGalleryItemSelected]--selectState:" + getSelectState() + ",mediaType:" + mediaInfo.getMMediaType());
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onQualityRawChangeEvent(LocalMediaInfo mediaInfo, boolean isChecked) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        super.onQualityRawChangeEvent(mediaInfo, isChecked);
        doRebindView(mediaInfo);
    }

    private final void onAlbumPreviewSendBtnClick(View sendBtn) {
        if (sendBtn == null) {
            return;
        }
        LocalMediaInfo a16 = getPreviewData().a();
        if (getSelectedMediaList().isEmpty() && a16 != null) {
            if (!isValid(a16, true)) {
                return;
            }
            if (canSelectInCurState(a16) && a16.getSelectStatus() != 1 && com.tencent.qqnt.qbasealbum.ktx.b.h(a16) == 0) {
                QAlbumPickerContext.f361201a.g().a().a(sendBtn, a16, PageType.LOCAL_ALL, com.tencent.qqnt.qbasealbum.album.b.g(getActivity()));
                Logger.f235387a.d().d(TAG, 1, "[onAlbumPreviewSendBtnClick]--select curMedia:" + a16.getPath());
            }
        }
        doSend();
    }

    private final boolean isValid(LocalMediaInfo mediaInfo, boolean needShowToast) {
        String[] strArr = needShowToast ? null : new String[]{""};
        if (TextUtils.isEmpty(mediaInfo.getPath())) {
            QLog.e(TAG, 1, "onSelectClick path is empty");
            QQToastUtil.showQQToast(R.string.f144380om);
            return false;
        }
        a aVar = a.f214243a;
        return aVar.q(mediaInfo) ? a.C7671a.f214244d.isValidImage(mediaInfo, strArr) == 0 : aVar.r(mediaInfo) && a.C7671a.f214244d.isValidVideo(mediaInfo, strArr) == 0;
    }

    static /* synthetic */ boolean isValid$default(GuildFeedPublishPreviewCustomization guildFeedPublishPreviewCustomization, LocalMediaInfo localMediaInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return guildFeedPublishPreviewCustomization.isValid(localMediaInfo, z16);
    }
}
