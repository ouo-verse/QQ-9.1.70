package ck2;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqvideoedit.api.IVideoExportApi;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorFragment;
import com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportProgress;
import com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0012\u001a\u00020\u0005H\u0014\u00a8\u0006\u0015"}, d2 = {"Lck2/g;", "Lck2/f;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "originMediaInfo", "localMediaInfo", "", "ea", "", "da", "ba", "originInfo", "ga", "ca", "Lcom/tencent/mobileqq/qqvideoedit/editor/export/VideoExportViewModel;", "vm", "Lcom/tencent/mobileqq/qqvideoedit/editor/export/b;", "state", "Y9", "U9", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g extends f {
    private final boolean ba() {
        Intent intent;
        Activity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || !intent.getBooleanExtra(PeakConstants.VIDEO_EDIT_GAME_STRATEGY_PUBLISH, false)) {
            return false;
        }
        return true;
    }

    private final void ca(LocalMediaInfo localMediaInfo) {
        ActivityURIRequest activityURIRequest;
        if (localMediaInfo == null) {
            QLog.e(this.TAG, 1, "navigateToVideoPreview error, localMediaInfo is null!");
            return;
        }
        if (getActivity() == null) {
            QLog.e(this.TAG, 1, "navigateToVideoPreview error, activity is null!");
            return;
        }
        if (getActivity().getIntent() == null) {
            QLog.e(this.TAG, 1, "navigateToVideoPreview error, activity.intent is null!");
            return;
        }
        if (getActivity().getIntent().getBooleanExtra(PeakConstants.USE_NEW_ALBUM, false)) {
            activityURIRequest = new ActivityURIRequest(getActivity(), IPhotoLogicFactory.BASE_ALBUM_HOME_ACTIVITY_URI);
        } else {
            activityURIRequest = new ActivityURIRequest(getActivity(), IPhotoLogicFactory.PHOTO_PREVIEW_ACTIVITY_URI);
        }
        activityURIRequest.extra().putAll(getActivity().getIntent().getExtras());
        ((IVideoExportApi) QRoute.api(IVideoExportApi.class)).fillPreviewAndSendVideoParams(activityURIRequest.extra());
        com.tencent.mobileqq.qqvideoedit.utils.e.f276246a.a(localMediaInfo);
        HashMap hashMap = new HashMap();
        hashMap.put(localMediaInfo.path, localMediaInfo);
        activityURIRequest.extra().putSerializable(QAlbumConstants.ALL_MEDIA_PATHS, hashMap);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(localMediaInfo.path);
        activityURIRequest.extra().putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList);
        activityURIRequest.setRequestCode(10004);
        activityURIRequest.setFlags(603979776);
        QRoute.startUri(activityURIRequest);
        getActivity().setResult(-1);
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, R.anim.dialog_exit);
        }
    }

    private final boolean da() {
        Intent intent;
        Activity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || !intent.getBooleanExtra(PeakConstants.VIDEO_EDIT_AND_THEN_PREVIEW, false)) {
            return false;
        }
        return true;
    }

    private final void ea(LocalMediaInfo originMediaInfo, LocalMediaInfo localMediaInfo) {
        Intent intent = getActivity().getIntent();
        HashMap hashMap = new HashMap();
        if (originMediaInfo != null && localMediaInfo != null && !TextUtils.isEmpty(originMediaInfo.path) && !TextUtils.isEmpty(localMediaInfo.path)) {
            String str = originMediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(str, "originMediaInfo.path");
            String str2 = localMediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(str2, "localMediaInfo.path");
            hashMap.put(str, str2);
            intent.putExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP, hashMap);
        }
        getActivity().setResult(-1, intent);
        getActivity().finish();
        getActivity().overridePendingTransition(0, R.anim.dialog_exit);
        QLog.i(this.TAG, 1, "[returnToGameStrategy] finish end,editMap:" + hashMap.size());
    }

    private final void ga(LocalMediaInfo originInfo, LocalMediaInfo localMediaInfo) {
        String str;
        if (localMediaInfo != null && getActivity() != null) {
            Intent intent = getActivity().getIntent();
            com.tencent.mobileqq.qqvideoedit.utils.e.f276246a.a(localMediaInfo);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(localMediaInfo.path);
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
            intent.putExtra(PeakConstants.SEND_PICTURE_ORIGIN, false);
            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList.get(0));
            intent.putExtra(PeakConstants.SEND_FLAG, true);
            if (originInfo != null) {
                str = originInfo.path;
            } else {
                str = null;
            }
            intent.putExtra(PeakConstants.KEY_MULIT_EDIT_SOURTH_PATH, str);
            intent.putExtra("open_chatfragment_fromphoto", true);
            intent.putExtra(AEEditorConstants.EXTRA_IS_EDITED_PIC, true);
            intent.putExtra(PeakConstants.SEND_PICTURE_ORIGIN, false);
            Intrinsics.checkNotNull(originInfo, "null cannot be cast to non-null type java.io.Serializable");
            intent.putExtra(PeakConstants.VIDEO_EDIT_OLD_MEDIA, (Serializable) originInfo);
            intent.putExtra(PeakConstants.VIDEO_EDIT_NEW_MEDIA, (Serializable) localMediaInfo);
            Activity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1, intent);
            }
            Activity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
            Activity activity3 = getActivity();
            if (activity3 != null) {
                activity3.overridePendingTransition(0, R.anim.dialog_exit);
            }
        }
    }

    @Override // ck2.f
    protected void U9() {
        QQToast.makeText(getContext(), 1, R.string.f238017im, 0).show();
    }

    @Override // ck2.f
    protected void Y9(@NotNull VideoExportViewModel vm5, @NotNull VideoExportProgress state, @Nullable LocalMediaInfo originInfo) {
        Integer num;
        Intent intent;
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(state, "state");
        if (getActivity() != null) {
            if (ba()) {
                ea(originInfo, state.getLocalMediaInfo());
                return;
            }
            if (da()) {
                Activity activity = getActivity();
                if (activity != null && (intent = activity.getIntent()) != null) {
                    num = Integer.valueOf(intent.getIntExtra(PeakConstants.KEY_PIC_TO_EDIT_FROM, 0));
                } else {
                    num = null;
                }
                if ((num == null || num.intValue() != 4) && (num == null || num.intValue() != 5)) {
                    ga(originInfo, state.getLocalMediaInfo());
                    return;
                } else {
                    ca(state.getLocalMediaInfo());
                    return;
                }
            }
            VideoEditorFragment D9 = D9();
            if (D9 != null) {
                D9.Mj(state.getLocalMediaInfo());
            }
        }
    }
}
