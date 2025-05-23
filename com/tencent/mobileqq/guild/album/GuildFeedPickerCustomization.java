package com.tencent.mobileqq.guild.album;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.album.a;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.temp.api.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.utils.MediaTypeHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 S*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001TB\u001d\u0012\u0006\u0010N\u001a\u00020M\u0012\f\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000O\u00a2\u0006\u0004\bQ\u0010RJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0002J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010H\u0002J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\bH\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0006H\u0002J\b\u0010(\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020\bH\u0002J\u0012\u0010-\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010)H\u0016J\u001a\u00103\u001a\u0004\u0018\u0001022\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0016J\u0018\u00104\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u00105\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J \u00107\u001a\u00020\b2\u0006\u0010/\u001a\u00020.2\u0006\u00106\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u00109\u001a\u00020\b2\u0006\u00108\u001a\u000202H\u0016J\u001a\u0010:\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010)2\u0006\u0010/\u001a\u00020.H\u0016J\"\u0010>\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u00102\b\u0010=\u001a\u0004\u0018\u00010)H\u0016J \u0010A\u001a\u00020\b2\u0006\u0010?\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0010H\u0016J\u0010\u0010C\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u0006H\u0016R\u0016\u0010D\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010ER\u0016\u0010G\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/guild/album/GuildFeedPickerCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "isSelected", "", VasPerfReportUtils.WHILE_UPDATE_ITEM, "isGesture", "doCheckMutexMediaSelect", "doCheckMediaSelect", "isValidVideo", "photoInfo", "isValidImage", "", "getSelectState", "Lcom/tencent/qqnt/qbasealbum/base/view/e;", "viewHolder", "doBindViewHolderByState", "canSelect", "updateItemView", "canSelectItem", "curNum", "maxNum", "canMutexSelect", "canNormalSelect", "getCurPhotoNum", "getCurVideoNum", "mediaType", "selectSize", "selectMaxLimitToast", "type", "getSelectedMediaCount", "getMediaState", "getMaxSelectNum", "asyncParseImage", "hasQrCode", "runOnUIHandler", "onSelectFinish", "Landroid/content/Intent;", "getIntent", "updateMagicStick", "intent", "initData", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getBottomView", "onMediaSelectEvent", "checkMediaSelect", "holder", "bindPickerHolder", "v", "onSendBtnClick", "onNewIntent", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "view", "layoutPosition", "onItemClickEvent", "isQualityRaw", "onQualityRawChangeEvent", "maxSelectPhotoNum", "I", "maxSelectVideoNum", "needMutexMedia", "Z", "checkQrCode", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "progressDialog", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "Companion", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildFeedPickerCustomization<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends PickerCustomizationBase<O> {
    private static final a Companion = new a(null);

    @Deprecated
    private static final String TAG = "GuildFeedPicker";
    private boolean checkQrCode;
    private int maxSelectPhotoNum;
    private int maxSelectVideoNum;
    private boolean needMutexMedia;
    private QQProgressDialog progressDialog;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/album/GuildFeedPickerCustomization$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedPickerCustomization(FragmentActivity activity, com.tencent.qqnt.qbasealbum.customization.common.b<O> photoCommonData) {
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
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.album.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPickerCustomization.asyncParseImage$lambda$3(GuildFeedPickerCustomization.this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncParseImage$lambda$3(GuildFeedPickerCustomization this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<LocalMediaInfo> it = this$0.getPhotoCommonData().h().iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            }
            LocalMediaInfo next = it.next();
            com.tencent.mobileqq.guild.album.a.f214243a.e(next);
            if (this$0.checkQrCode && gg1.a.a(next.getPath())) {
                z16 = true;
                break;
            }
        }
        com.tencent.mobileqq.guild.album.a.f214243a.f(this$0.getPhotoCommonData().h());
        this$0.runOnUIHandler(z16);
    }

    private final boolean canMutexSelect(LocalMediaInfo mediaInfo, int curNum, int maxNum) {
        if (getSelectState() != com.tencent.mobileqq.guild.album.a.f214243a.p(mediaInfo)) {
            return false;
        }
        return curNum < maxNum || mediaInfo.getSelectStatus() == 1;
    }

    private final boolean canSelectItem(LocalMediaInfo mediaInfo) {
        int curPhotoNum;
        int i3;
        com.tencent.mobileqq.guild.album.a aVar = com.tencent.mobileqq.guild.album.a.f214243a;
        if (aVar.r(mediaInfo)) {
            curPhotoNum = getCurVideoNum();
        } else {
            curPhotoNum = getCurPhotoNum();
        }
        if (aVar.r(mediaInfo)) {
            i3 = this.maxSelectVideoNum;
        } else {
            i3 = this.maxSelectPhotoNum;
        }
        if (this.needMutexMedia) {
            return canMutexSelect(mediaInfo, curPhotoNum, i3);
        }
        return canNormalSelect(mediaInfo, curPhotoNum, i3);
    }

    private final void doBindViewHolderByState(com.tencent.qqnt.qbasealbum.base.view.e viewHolder, LocalMediaInfo mediaInfo) {
        int selectState = getSelectState();
        int mediaState = getMediaState(mediaInfo);
        if (selectState == 0) {
            updateItemView(true, viewHolder);
            return;
        }
        if (selectState != mediaState && this.needMutexMedia) {
            updateItemView(false, viewHolder);
        } else if (canSelectItem(mediaInfo)) {
            updateItemView(true, viewHolder);
        } else {
            updateItemView(false, viewHolder);
        }
    }

    private final boolean doCheckMutexMediaSelect(LocalMediaInfo mediaInfo, boolean isSelected, boolean isGesture) {
        int n3 = com.tencent.mobileqq.guild.album.a.f214243a.n(mediaInfo);
        int selectState = getSelectState();
        int size = getPhotoCommonData().h().size();
        if (n3 != 0) {
            if (n3 != 1 || ((selectState != 0 && selectState != 2) || !isValidVideo(mediaInfo))) {
                return false;
            }
            if (isSelected && size >= this.maxSelectVideoNum) {
                return false;
            }
            return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
        }
        if ((selectState != 0 && selectState != 1) || !isValidImage(mediaInfo)) {
            return false;
        }
        if (isSelected && size >= this.maxSelectPhotoNum) {
            return false;
        }
        return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
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

    private final int getMaxSelectNum() {
        if (getSelectState() == 1) {
            return this.maxSelectPhotoNum;
        }
        return this.maxSelectVideoNum;
    }

    private final int getMediaState(LocalMediaInfo mediaInfo) {
        return MediaTypeHelper.f361628a.a(mediaInfo) == 0 ? 1 : 2;
    }

    private final int getSelectState() {
        List<LocalMediaInfo> h16 = getPhotoCommonData().h();
        if (!h16.isEmpty()) {
            return com.tencent.mobileqq.guild.album.a.f214243a.q(h16.get(0)) ? 1 : 2;
        }
        return 0;
    }

    private final int getSelectedMediaCount(int type) {
        Iterator<T> it = getPhotoCommonData().h().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((LocalMediaInfo) it.next()).getMMediaType() == type) {
                i3++;
            }
        }
        return i3;
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

    private final void runOnUIHandler(final boolean hasQrCode) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.album.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPickerCustomization.runOnUIHandler$lambda$4(GuildFeedPickerCustomization.this, hasQrCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnUIHandler$lambda$4(GuildFeedPickerCustomization this$0, boolean z16) {
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

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
    
        if (r1.q((com.tencent.qqnt.qbasealbum.model.LocalMediaInfo) r0) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateMagicStick() {
        Object first;
        List<LocalMediaInfo> h16 = getPhotoCommonData().h();
        boolean z16 = true;
        if (h16.size() == 1) {
            com.tencent.mobileqq.guild.album.a aVar = com.tencent.mobileqq.guild.album.a.f214243a;
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) h16);
        }
        z16 = false;
        TextView magicBtn = getMagicBtn();
        if (magicBtn != null) {
            magicBtn.setClickable(z16);
            magicBtn.setTextColor(magicBtn.getContext().getColorStateList(z16 ? R.color.qui_common_text_primary : R.color.qui_common_text_secondary_light));
        }
    }

    private final void updateView(LocalMediaInfo mediaInfo, boolean isSelected) {
        com.tencent.qqnt.qbasealbum.a.f360732a.l();
        updateMagicStick();
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
        if (this.needMutexMedia) {
            return doCheckMutexMediaSelect(mediaInfo, isSelected, isGesture);
        }
        return doCheckMediaSelect(mediaInfo, isSelected, isGesture);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.a
    public View getBottomView(Context context, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View bottomView = super.getBottomView(context, parent);
        ViewGroup viewGroup = bottomView instanceof ViewGroup ? (ViewGroup) bottomView : null;
        Button sendBtn = getSendBtn();
        if (sendBtn != null) {
            sendBtn.setText(context.getString(R.string.f1518418s));
        }
        if (!getPhotoCommonData().g()) {
            TextView qualityTv = getQualityTv();
            if (qualityTv != null) {
                qualityTv.setVisibility(8);
            }
            CheckBox qualityCb = getQualityCb();
            if (qualityCb != null) {
                qualityCb.setVisibility(8);
            }
            TextView mediaSizeTv = getMediaSizeTv();
            if (mediaSizeTv != null) {
                mediaSizeTv.setVisibility(8);
            }
            TextView qualityTv2 = getQualityTv();
            if (qualityTv2 != null) {
                qualityTv2.setClickable(false);
            }
            CheckBox qualityCb2 = getQualityCb();
            if (qualityCb2 != null) {
                qualityCb2.setClickable(false);
            }
            TextView mediaSizeTv2 = getMediaSizeTv();
            if (mediaSizeTv2 != null) {
                mediaSizeTv2.setClickable(false);
            }
        }
        return viewGroup;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void initData(Intent intent) {
        super.initData(intent);
        if (intent != null) {
            this.maxSelectPhotoNum = intent.getIntExtra("key_guild_feed_publish_max_photo", 9);
            this.needMutexMedia = intent.getBooleanExtra("key_guild_feed_need_mutex_media", false);
            this.checkQrCode = intent.getBooleanExtra("key_guild_check_qrcode_image", false);
            this.maxSelectVideoNum = intent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 9);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onItemClickEvent(View view, LocalMediaInfo mediaInfo, int layoutPosition) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (mediaInfo.getSelectStatus() != 1) {
            com.tencent.mobileqq.guild.album.a aVar = com.tencent.mobileqq.guild.album.a.f214243a;
            boolean z16 = false;
            if (aVar.q(mediaInfo)) {
                z16 = selectMaxLimitToast(0, getCurPhotoNum());
            } else if (aVar.r(mediaInfo)) {
                z16 = selectMaxLimitToast(1, getCurVideoNum());
            }
            QLog.i(TAG, 1, "[onItemClickEvent],overMax:" + z16);
            if (z16) {
                return;
            }
        }
        super.onItemClickEvent(view, mediaInfo, layoutPosition);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onMediaSelectEvent(LocalMediaInfo mediaInfo, boolean isSelected) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        updateView(mediaInfo, isSelected);
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
                        return;
                    }
                    return;
                }
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

    private final boolean doCheckMediaSelect(LocalMediaInfo mediaInfo, boolean isSelected, boolean isGesture) {
        if (!isSelected) {
            return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
        }
        int mMediaType = mediaInfo.getMMediaType();
        if (mMediaType == 0) {
            if (isValidImage(mediaInfo) && getCurPhotoNum() < this.maxSelectPhotoNum) {
                return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
            }
            return false;
        }
        if (mMediaType != 1) {
            return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
        }
        if (isValidVideo(mediaInfo) && getCurVideoNum() < this.maxSelectVideoNum) {
            return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
        }
        return false;
    }

    private final boolean selectMaxLimitToast(int mediaType, int selectSize) {
        int i3;
        String string;
        if (mediaType == 0) {
            i3 = this.maxSelectPhotoNum;
        } else {
            i3 = this.maxSelectVideoNum;
        }
        if (i3 == 0 || selectSize < i3) {
            return false;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        if (mediaType == 0) {
            string = getActivity().getString(R.string.w2l);
        } else {
            string = getActivity().getString(R.string.w2o);
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (mediaType == MediaTy\u2026deo2_limit)\n            }");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QQToastUtil.showQQToast(-1, format);
        return true;
    }

    private final void updateItemView(boolean canSelect, com.tencent.qqnt.qbasealbum.base.view.e viewHolder) {
        if (canSelect) {
            viewHolder.itemView.setAlpha(1.0f);
            FrameLayout t16 = viewHolder.t();
            if (t16 == null) {
                return;
            }
            t16.setVisibility(0);
            return;
        }
        viewHolder.itemView.setAlpha(0.3f);
        FrameLayout t17 = viewHolder.t();
        if (t17 == null) {
            return;
        }
        t17.setVisibility(8);
    }

    private final boolean canNormalSelect(LocalMediaInfo mediaInfo, int curNum, int maxNum) {
        return curNum < maxNum || mediaInfo.getSelectStatus() == 1;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10014 && resultCode == -1) {
            getActivity().setResult(-1, data);
            getActivity().finish();
            QAlbumUtil.anim(getActivity(), false, false);
        }
    }
}
