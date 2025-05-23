package com.tencent.mobileqq.zplan.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanDebugHelper;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.debug.ZPlanDebugGroup;
import com.tencent.mobileqq.zplan.utils.DebugUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.AppSetting;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.json.JSONObject;
import uv4.al;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanDebugHelperImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanDebugHelper;", "", "isDebugToolValid", "", "filePath", "", "sendFileWithLocalPath", "Lcom/tencent/mobileqq/filemanager/data/ForwardFileInfo;", "forwardFileInfo", "requestForwardFileToFriend", "isUploadAvatarChecked", "avatarString", "cacheDirPath", "zipAndUploadAvatarJsonToWorkChat", "Luv4/al;", "currentAvatar", "Ldw4/b;", "result", "shareAvatarCharacterIfNeed", "Landroid/content/Context;", "context", "jumpToZPlanDebugFragment", "Landroid/widget/TextView;", "tv", "tryShowLongTextForTemplate", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanDebugHelperImpl implements IZPlanDebugHelper {
    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDebugToolValid() {
        if (AppSetting.isGrayVersion() || AppSetting.isPublicVersion()) {
            return false;
        }
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("zplan_share_card_debug_panel", false);
    }

    private final void requestForwardFileToFriend(ForwardFileInfo forwardFileInfo) {
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        Activity activityFromContext = iZPlanApi.getActivityFromContext(context);
        if (activityFromContext == null) {
            activityFromContext = Foreground.getTopActivity();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 0);
        bundle.putParcelable("fileinfo", forwardFileInfo);
        bundle.putBoolean("not_forward", true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, forwardFileInfo.f());
        intent.putExtra("forward_type", 0);
        intent.putExtra("forward _key_nojump", false);
        ForwardBaseOption.startForwardActivityForResult(activityFromContext, intent, 103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendFileWithLocalPath(String filePath) {
        if (!(filePath.length() == 0) && new File(filePath).exists() && new File(filePath).isFile()) {
            FileInfo fileInfo = new FileInfo(filePath);
            ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
            forwardFileInfo.E(FileManagerUtil.newEntityByLocalFileInfo(fileInfo).nSessionId);
            forwardFileInfo.w(3);
            forwardFileInfo.N(10000);
            forwardFileInfo.C(fileInfo.k());
            forwardFileInfo.y(fileInfo.j());
            forwardFileInfo.z(fileInfo.l());
            requestForwardFileToFriend(forwardFileInfo);
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanDebugHelper
    public boolean isUploadAvatarChecked() {
        return uk3.i.f439124a.e();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanDebugHelper
    public void jumpToZPlanDebugFragment(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, ZPlanDebugGroup.class);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanDebugHelper
    public void shareAvatarCharacterIfNeed(final al currentAvatar, final dw4.b result) {
        Intrinsics.checkNotNullParameter(currentAvatar, "currentAvatar");
        Intrinsics.checkNotNullParameter(result, "result");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanDebugHelperImpl$shareAvatarCharacterIfNeed$1
            @Override // java.lang.Runnable
            public void run() {
                boolean isDebugToolValid;
                qu4.a aVar;
                JSONObject h16;
                String jSONObject;
                isDebugToolValid = ZPlanDebugHelperImpl.this.isDebugToolValid();
                if (!isDebugToolValid || (aVar = currentAvatar.f440152a) == null || (h16 = r94.c.h(aVar)) == null || (jSONObject = h16.toString()) == null) {
                    return;
                }
                File file = new File(di3.a.f393982a.a(), "zplan/avatar_character_info/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str = file + "/" + result.f395115b + ".txt";
                FilesKt__FileReadWriteKt.writeText$default(new File(str), jSONObject, null, 2, null);
                ZPlanDebugHelperImpl.this.sendFileWithLocalPath(str);
            }
        }, 96, null, true);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanDebugHelper
    public void tryShowLongTextForTemplate(TextView tv5) {
        if (AppSetting.isGrayVersion() || AppSetting.isPublicVersion()) {
            return;
        }
        ((com.tencent.mobileqq.zootopia.ipc.l) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.l.class)).isSwitchOn(1003, new a(tv5));
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanDebugHelper
    public void zipAndUploadAvatarJsonToWorkChat(String avatarString, String cacheDirPath) {
        Intrinsics.checkNotNullParameter(avatarString, "avatarString");
        Intrinsics.checkNotNullParameter(cacheDirPath, "cacheDirPath");
        DebugUtils.f335718a.g(avatarString, cacheDirPath);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/api/impl/ZPlanDebugHelperImpl$a", "Lcom/tencent/mobileqq/zootopia/ipc/k;", "", "result", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.ipc.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f331352a;

        a(TextView textView) {
            this.f331352a = textView;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.k
        public void onResult(boolean result) {
            TextView textView;
            if (!result || (textView = this.f331352a) == null) {
                return;
            }
            textView.setText("\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8\u54c8");
        }
    }
}
