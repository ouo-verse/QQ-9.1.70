package com.tencent.state.square.resource;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.state.SquareRuntime;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.DressKeys;
import com.tencent.state.square.data.FilamentAvatarCoverUri;
import com.tencent.state.square.data.FilamentCoverResource;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.state.square.resource.FilamentCoverRecorder;
import com.tencent.state.utils.SquareSwitchUtils;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JN\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/resource/FilamentCoverRecordHelper;", "", "()V", "TAG", "", "uploadedFiles", "", "checkAndRecord", "", "recorder", "Lcom/tencent/state/square/resource/FilamentCoverRecorder;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "uin", "toUin", "resource", "Lcom/tencent/state/square/data/Resource;", "needUpload", "", "recordType", "Lcom/tencent/state/square/record/RecordType;", "callback", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$IRecordCallback;", "cleanup", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FilamentCoverRecordHelper {
    private static final String TAG = "FilamentCoverRecordHelper";
    public static final FilamentCoverRecordHelper INSTANCE = new FilamentCoverRecordHelper();
    private static final Set<String> uploadedFiles = new LinkedHashSet();

    FilamentCoverRecordHelper() {
    }

    public final void cleanup() {
        Set<String> set = uploadedFiles;
        synchronized (set) {
            set.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void checkAndRecord(FilamentCoverRecorder recorder, String taskId, String uin, String toUin, Resource resource, boolean needUpload, RecordType recordType, final FilamentCoverRecorder.IRecordCallback callback) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        if (recorder == null || resource == null || resource.getFilament().isRecordCoverCorrect()) {
            return;
        }
        if (!SquareRuntime.INSTANCE.hasNearbyMark() && !SquareSwitchUtils.INSTANCE.enableFilamentIndex()) {
            SquareBaseKt.getSquareLog().i(TAG, "\u672a\u5f00\u542f\u5927\u5e7f\u573a\uff0c\u4e0d\u8fdb\u884c\u9996\u5e27\u5f55\u5236");
            return;
        }
        final FilamentAvatarCoverUri filamentCoverUrl = resource.getFilamentCoverUrl();
        Set<String> set = uploadedFiles;
        synchronized (set) {
            if (set.contains(filamentCoverUrl.getCachePath())) {
                if (SquareBaseKt.getSquareLog().isColorLevel()) {
                    SquareLogger squareLog = SquareBaseKt.getSquareLog();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("\u540c\u6587\u4ef6\u5df2\u7ecf\u4e0a\u4f20\u8fc7\uff0c\u4e0d\u518d\u91cd\u590d\u5f55\u5236\u4e0a\u4f20, uin=");
                    sb5.append(uin);
                    sb5.append(", toUin=");
                    sb5.append(toUin);
                    sb5.append(", resource=");
                    sb5.append(resource.getActionId());
                    sb5.append(", ");
                    sb5.append("recordDressKey=");
                    FilamentCoverResource recordCover = resource.getFilament().getRecordCover();
                    sb5.append(recordCover != null ? recordCover.getRecordDressKeys() : null);
                    sb5.append(", ");
                    sb5.append("backendDressKey=");
                    sb5.append(resource.getFilament().getUserDressKey());
                    squareLog.d(TAG, sb5.toString());
                }
                return;
            }
            Unit unit = Unit.INSTANCE;
            SquareBaseKt.getSquareLog().i(TAG, "\u5c01\u9762\u9519\u8bef\uff0c\u542f\u52a8\u5f55\u5236, uin=" + uin + ", toUin=" + toUin + ", resource=" + resource.getActionId() + ", needUpload=" + needUpload + TokenParser.SP + "recordCover=" + resource.getFilament().getRecordCover() + ", backendDressKey=" + resource.getFilament().getUserDressKey());
            DressKeys userDressKey = resource.getFilament().getUserDressKey();
            if (userDressKey != null) {
                SquareRecordManager squareRecordManager = SquareRecordManager.INSTANCE;
                squareRecordManager.setGuestCacheDressKey(uin, userDressKey.getOwner());
                if (toUin != null) {
                    squareRecordManager.setGuestCacheDressKey(toUin, userDressKey.getOther());
                }
            }
            recorder.startRecord(new FilamentCoverRecorder.RecordRequest(taskId, new UserIdentifier(uin, null, 2, null), toUin != null ? new UserIdentifier(toUin, null, 2, null) : null, resource, filamentCoverUrl.getCachePath(), needUpload, recordType), new FilamentCoverRecorder.IRecordCallback() { // from class: com.tencent.state.square.resource.FilamentCoverRecordHelper$checkAndRecord$3
                @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
                public void onRecordError(int type, FilamentCoverRecorder.RecordRequest request, int errorCode) {
                    Intrinsics.checkNotNullParameter(request, "request");
                    FilamentCoverRecorder.IRecordCallback iRecordCallback = callback;
                    if (iRecordCallback != null) {
                        iRecordCallback.onRecordError(type, request, errorCode);
                    }
                }

                @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
                public void onRecordSuccess(FilamentCoverRecorder.RecordRequest request, RecordSource cover) {
                    Set set2;
                    Set set3;
                    Intrinsics.checkNotNullParameter(request, "request");
                    Intrinsics.checkNotNullParameter(cover, "cover");
                    if (request.getNeedUpload()) {
                        FilamentCoverRecordHelper filamentCoverRecordHelper = FilamentCoverRecordHelper.INSTANCE;
                        set2 = FilamentCoverRecordHelper.uploadedFiles;
                        synchronized (set2) {
                            set3 = FilamentCoverRecordHelper.uploadedFiles;
                            set3.add(FilamentAvatarCoverUri.this.getCachePath());
                        }
                    }
                    FilamentCoverRecorder.IRecordCallback iRecordCallback = callback;
                    if (iRecordCallback != null) {
                        iRecordCallback.onRecordSuccess(request, cover);
                    }
                }
            });
        }
    }
}
