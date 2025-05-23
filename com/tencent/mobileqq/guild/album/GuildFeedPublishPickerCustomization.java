package com.tencent.mobileqq.guild.album;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.album.a;
import com.tencent.mobileqq.guild.temp.api.e;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import ue1.a;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 W*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001XB\u001d\u0012\u0006\u0010R\u001a\u00020Q\u0012\f\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000S\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0012\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\u0001H\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0016J\u0016\u0010-\u001a\u00020\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0+H\u0016J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0006H\u0016J \u00102\u001a\u00020\u00042\u0006\u00100\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u0017H\u0016J \u00104\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006H\u0016J \u00106\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0006\u00105\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u00020)H\u0016J\u001a\u00109\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0006H\u0016R\u0016\u0010<\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010=R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000b0+8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR$\u0010M\u001a\u0012\u0012\u0004\u0012\u00020I0Hj\b\u0012\u0004\u0012\u00020I`J8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010O\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/guild/album/GuildFeedPublishPickerCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "", "updateEditBtn", "", "canSend", "updateSendBtnUi", "Lcom/tencent/qqnt/qbasealbum/base/view/e;", "viewHolder", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "canSelect", "updateAlbumSelectNumber", VasPerfReportUtils.WHILE_UPDATE_ITEM, "mediaInfo", "isValidVideo", "photoInfo", "isValidImage", "doBindViewHolderByState", "canSelectInCurState", "updateItemView", "", "getCurPhotoNum", "getCurVideoNum", "selectSize", "selectMaxLimitToast", "getMaxSelectNum", "asyncParseImage", "runOnUIHandler", "onSelectFinish", "Landroid/content/Intent;", "getIntent", "intent", "initData", "generateOtherData", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getBottomView", "", "selectedMedia", "onMediaInitEvent", "isSelected", "onMediaSelectEvent", "view", "layoutPosition", "onItemClickEvent", "isGesture", "checkMediaSelect", "holder", "bindPickerHolder", "v", "onSendBtnClick", "onNewIntent", "isQualityRaw", "onQualityRawChangeEvent", "maxSelectPhotoNum", "I", "maxSelectVideoNum", "", "sendBtnText", "Ljava/lang/String;", "Lue1/a;", "otherData", "Lue1/a;", "getSelectedMediaList", "()Ljava/util/List;", "selectedMediaList", "Ljava/util/ArrayList;", "Lue1/a$b;", "Lkotlin/collections/ArrayList;", "getMediaHandleList", "()Ljava/util/ArrayList;", "mediaHandleList", "getSelectState", "()I", "selectState", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "Companion", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildFeedPublishPickerCustomization<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends PickerCustomizationBase<O> {
    private static final a Companion = new a(null);

    @Deprecated
    private static final String TAG = "GuildFeedPublishPicker";
    private int maxSelectPhotoNum;
    private int maxSelectVideoNum;
    private ue1.a otherData;
    private String sendBtnText;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/album/GuildFeedPublishPickerCustomization$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedPublishPickerCustomization(FragmentActivity activity, com.tencent.qqnt.qbasealbum.customization.common.b<O> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        String string = activity.getString(R.string.f1518418s);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t\u2026ing.guild_pic_select_btn)");
        this.sendBtnText = string;
    }

    private final void asyncParseImage() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.album.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPublishPickerCustomization.asyncParseImage$lambda$7(GuildFeedPublishPickerCustomization.this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncParseImage$lambda$7(GuildFeedPublishPickerCustomization this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<LocalMediaInfo> it = this$0.getSelectedMediaList().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.guild.album.a.f214243a.e(it.next());
        }
        com.tencent.mobileqq.guild.album.a.f214243a.f(this$0.getSelectedMediaList());
        this$0.runOnUIHandler();
    }

    private final boolean canSelectInCurState(LocalMediaInfo mediaInfo) {
        return getSelectState() == 0 || getSelectState() == mediaInfo.getMMediaType() + 1;
    }

    private final void doBindViewHolderByState(com.tencent.qqnt.qbasealbum.base.view.e viewHolder, LocalMediaInfo mediaInfo) {
        int mMediaType = mediaInfo.getMMediaType();
        boolean z16 = true;
        if (getSelectState() != 0 && mediaInfo.getSelectStatus() != 1) {
            if ((getSelectState() == 2 && getCurVideoNum() >= this.maxSelectVideoNum) || (getSelectState() == 1 && getCurPhotoNum() >= this.maxSelectPhotoNum)) {
                z16 = false;
            }
            if (!canSelectInCurState(mediaInfo)) {
                z16 = false;
            }
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d(TAG, "[doBindViewHolderByState]--selectState:" + getSelectState() + ",mediaState:" + mMediaType + ",canSelect:" + z16);
        }
        updateItemView(z16, viewHolder, mediaInfo);
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
            ue1.a aVar = this.otherData;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otherData");
                aVar = null;
            }
            albumResult.o(aVar.m(getSelectedMediaList()));
            albumResult.m(getPhotoCommonData().j());
            albumResult.j(getPhotoCommonData().b());
            Unit unit = Unit.INSTANCE;
            extras.putParcelable("ALBUM_RESULT", albumResult);
            intent.putExtras(extras);
        }
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return intent;
    }

    private final int getMaxSelectNum() {
        if (getSelectState() == 1) {
            return this.maxSelectPhotoNum;
        }
        return this.maxSelectVideoNum;
    }

    private final ArrayList<a.MediaHandle> getMediaHandleList() {
        ue1.a aVar = this.otherData;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherData");
            aVar = null;
        }
        return aVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSelectState() {
        ue1.a aVar = this.otherData;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherData");
            aVar = null;
        }
        return aVar.get_selectState();
    }

    private final List<LocalMediaInfo> getSelectedMediaList() {
        return getPhotoCommonData().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean isValidImage(LocalMediaInfo photoInfo) {
        return e.a.a(a.C7671a.f214244d, photoInfo, null, 2, null) == 0;
    }

    private final boolean isValidVideo(LocalMediaInfo mediaInfo) {
        return e.a.b(a.C7671a.f214244d, mediaInfo, null, 2, null) == 0;
    }

    private final void onSelectFinish() {
        getActivity().setResult(-1, getIntent());
        getActivity().finish();
        QAlbumUtil.anim(getActivity(), false, false);
    }

    private final void runOnUIHandler() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.album.i
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPublishPickerCustomization.runOnUIHandler$lambda$8(GuildFeedPublishPickerCustomization.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnUIHandler$lambda$8(GuildFeedPublishPickerCustomization this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity().isFinishing() || this$0.getActivity().isDestroyed()) {
            return;
        }
        this$0.onSelectFinish();
    }

    private final boolean selectMaxLimitToast(int selectSize) {
        int maxSelectNum = getMaxSelectNum();
        if (maxSelectNum < 1 || selectSize < maxSelectNum) {
            return false;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getActivity().getString(getSelectState() == 2 ? R.string.f132563r : R.string.f132553q);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(\n    \u2026_limit_hint\n            )");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(maxSelectNum)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QQToastUtil.showQQToast(-1, format);
        return true;
    }

    private final void updateAlbumSelectNumber(com.tencent.qqnt.qbasealbum.base.view.e viewHolder, LocalMediaInfo info, boolean canSelect) {
        if (info.getPath() == null) {
            return;
        }
        QUICheckBox s16 = viewHolder.s();
        View u16 = viewHolder.u();
        ue1.a aVar = this.otherData;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherData");
            aVar = null;
        }
        int d16 = aVar.d(info) + 1;
        if (!canSelect || info.getSelectStatus() != 1 || d16 <= 0) {
            if (s16 != null) {
                s16.setChecked(false);
            }
            if (s16 != null) {
                s16.setText("");
            }
            if (u16 == null) {
                return;
            }
            u16.setVisibility(8);
            return;
        }
        QLog.i(TAG, 2, "[onSelectNumber]--selectNumber:" + d16 + ",path:" + info.getPath());
        if (s16 != null) {
            s16.setChecked(true);
        }
        if (s16 != null) {
            s16.setTextSize(2, 14.0f);
        }
        if (s16 != null) {
            s16.setText(String.valueOf(d16));
        }
        if (u16 == null) {
            return;
        }
        u16.setVisibility(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
    
        if (r0.e((com.tencent.qqnt.qbasealbum.model.LocalMediaInfo) r2) == 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateEditBtn() {
        Object first;
        boolean z16 = true;
        if (getSelectedMediaList().size() == 1) {
            ue1.a aVar = this.otherData;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otherData");
                aVar = null;
            }
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) getSelectedMediaList());
        }
        z16 = false;
        TextView magicBtn = getMagicBtn();
        if (magicBtn != null) {
            magicBtn.setClickable(z16);
            magicBtn.setTextColor(magicBtn.getContext().getColorStateList(z16 ? R.color.qui_common_text_primary : R.color.qui_common_text_secondary_light));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSendBtnUi(boolean canSend) {
        String str;
        if (!getMediaHandleList().isEmpty()) {
            str = "(" + getMediaHandleList().size() + ")";
        } else {
            str = "";
        }
        Button sendBtn = getSendBtn();
        if (sendBtn != null) {
            sendBtn.setText(this.sendBtnText + str);
        }
        Button sendBtn2 = getSendBtn();
        if (sendBtn2 != null) {
            sendBtn2.setAlpha(canSend ? 1.0f : 0.3f);
        }
        Button sendBtn3 = getSendBtn();
        if (sendBtn3 == null) {
            return;
        }
        sendBtn3.setClickable(canSend);
    }

    private final void updateView() {
        com.tencent.qqnt.qbasealbum.a.f360732a.l();
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.a
    public void bindPickerHolder(Context context, com.tencent.qqnt.qbasealbum.base.view.e holder, LocalMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        doBindViewHolderByState(holder, mediaInfo);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public boolean checkMediaSelect(LocalMediaInfo mediaInfo, boolean isSelected, boolean isGesture) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (!isSelected) {
            return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
        }
        int mMediaType = mediaInfo.getMMediaType();
        if (mMediaType == 0) {
            if (getSelectState() != 2 && isValidImage(mediaInfo) && getCurPhotoNum() < this.maxSelectPhotoNum) {
                return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
            }
            return false;
        }
        if (mMediaType != 1) {
            return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
        }
        if (getSelectState() != 1 && isValidVideo(mediaInfo) && getCurVideoNum() < this.maxSelectVideoNum) {
            return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
        }
        return false;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public com.tencent.qqnt.qbasealbum.customization.common.a generateOtherData() {
        ue1.a aVar = new ue1.a();
        this.otherData = aVar;
        return aVar;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.a
    public View getBottomView(Context context, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View bottomView = super.getBottomView(context, parent);
        if (bottomView instanceof ViewGroup) {
            return (ViewGroup) bottomView;
        }
        return null;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void initData(Intent intent) {
        super.initData(intent);
        ue1.a aVar = null;
        if (intent != null) {
            this.maxSelectPhotoNum = intent.getIntExtra("key_guild_feed_publish_max_photo", 9);
            this.maxSelectVideoNum = intent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 9);
            ArrayList mediaList = intent.getParcelableArrayListExtra("guild_feed_publish_local_media_key");
            if (mediaList != null) {
                ue1.a aVar2 = this.otherData;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("otherData");
                    aVar2 = null;
                }
                Intrinsics.checkNotNullExpressionValue(mediaList, "mediaList");
                aVar2.j(mediaList);
            }
        }
        ue1.a aVar3 = this.otherData;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherData");
        } else {
            aVar = aVar3;
        }
        LiveData<Boolean> h16 = aVar.h();
        FragmentActivity activity = getActivity();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(this) { // from class: com.tencent.mobileqq.guild.album.GuildFeedPublishPickerCustomization$initData$2
            final /* synthetic */ GuildFeedPublishPickerCustomization<O> this$0;

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
                GuildFeedPublishPickerCustomization<O> guildFeedPublishPickerCustomization = this.this$0;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildFeedPublishPickerCustomization.updateSendBtnUi(it.booleanValue());
            }
        };
        h16.observe(activity, new Observer() { // from class: com.tencent.mobileqq.guild.album.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedPublishPickerCustomization.initData$lambda$2(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onItemClickEvent(View view, LocalMediaInfo mediaInfo, int layoutPosition) {
        boolean selectMaxLimitToast;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (mediaInfo.getSelectStatus() != 1) {
            int selectState = getSelectState();
            if (selectState != 1) {
                selectMaxLimitToast = selectState != 2 ? false : selectMaxLimitToast(getCurVideoNum());
            } else {
                selectMaxLimitToast = selectMaxLimitToast(getCurPhotoNum());
            }
            QLog.i(TAG, 1, "[onItemClickEvent]--selectState:" + getSelectState() + ",overMax:" + selectMaxLimitToast);
            if (selectMaxLimitToast) {
                return;
            }
        }
        super.onItemClickEvent(view, mediaInfo, layoutPosition);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onMediaInitEvent(List<LocalMediaInfo> selectedMedia) {
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        ue1.a aVar = this.otherData;
        ue1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherData");
            aVar = null;
        }
        aVar.k(selectedMedia);
        ue1.a aVar3 = this.otherData;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherData");
        } else {
            aVar2 = aVar3;
        }
        aVar2.t();
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onMediaSelectEvent(LocalMediaInfo mediaInfo, boolean isSelected) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        ue1.a aVar = this.otherData;
        ue1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherData");
            aVar = null;
        }
        aVar.q(mediaInfo, isSelected);
        ue1.a.s(aVar, null, 1, null);
        updateView();
        updateEditBtn();
        ue1.a aVar3 = this.otherData;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherData");
        } else {
            aVar2 = aVar3;
        }
        aVar2.t();
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onNewIntent(Intent intent, Context context) {
        HashMap<String, String> c16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(intent != null && intent.getBooleanExtra("goEdit", false))) {
            QLog.d(TAG, 1, "[onNewIntent]: goEdit = false");
            super.onNewIntent(intent, context);
            return;
        }
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        String stringExtra2 = intent.getStringExtra(AEEditorConstants.PATH);
        if (!(stringExtra == null || stringExtra.length() == 0)) {
            if (!(stringExtra2 == null || stringExtra2.length() == 0)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "[onNewIntent]: editResultPath=" + stringExtra + ", origin=" + stringExtra2);
                }
                String F = LocalMediaDataHub.INSTANCE.a().F(stringExtra2, stringExtra);
                if (F != null) {
                    com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> a16 = CustomizationFacade.f361084a.a();
                    if (a16 != null && (c16 = a16.c()) != null) {
                        c16.put(F, stringExtra);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "[onNewIntent]: addReplaceEntry: origin=" + stringExtra2);
                    }
                }
                ue1.a aVar = this.otherData;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("otherData");
                    aVar = null;
                }
                aVar.p(getPhotoCommonData().c());
                return;
            }
        }
        QLog.e(TAG, 1, "[onNewIntent]: missing path, editResultPath=" + stringExtra + ", origin=" + stringExtra2);
        super.onNewIntent(intent, context);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onQualityRawChangeEvent(boolean isQualityRaw) {
        QLog.i(TAG, 1, "[onItemClickEvent], isQualityRaw: " + isQualityRaw);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onSendBtnClick(View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        asyncParseImage();
    }

    private final void updateItemView(boolean canSelect, com.tencent.qqnt.qbasealbum.base.view.e viewHolder, LocalMediaInfo mediaInfo) {
        if (canSelect) {
            ImageView q16 = viewHolder.q();
            if (q16 != null) {
                q16.setAlpha(1.0f);
            }
            FrameLayout t16 = viewHolder.t();
            if (t16 != null) {
                t16.setVisibility(0);
            }
        } else {
            ImageView q17 = viewHolder.q();
            if (q17 != null) {
                q17.setAlpha(0.3f);
            }
            FrameLayout t17 = viewHolder.t();
            if (t17 != null) {
                t17.setVisibility(8);
            }
        }
        updateAlbumSelectNumber(viewHolder, mediaInfo, canSelect);
    }
}
