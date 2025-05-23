package com.tencent.guild.aio.help;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.api.media.album.GuildAlbumMediaType;
import com.tencent.guild.api.media.album.GuildPickPhotoResult;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00032\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\n0\nH\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/guild/aio/help/SendMsgFromCameraHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "e", "Landroid/os/Bundle;", "args", tl.h.F, "Landroid/content/Intent;", "intent", "g", "", "filePath", "videoThumbPath", "c", "", "Lcom/tencent/guild/api/media/album/d;", "mediaList", "i", "", "getId", "kotlin.jvm.PlatformType", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class SendMsgFromCameraHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b helperParam;

    private final void c(String filePath, String videoThumbPath) {
        boolean z16;
        boolean contains$default;
        boolean contains$default2;
        GuildAlbumMediaType guildAlbumMediaType;
        List<GuildPickPhotoResult> mutableListOf;
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(filePath));
        if (mimeTypeFromExtension != null && mimeTypeFromExtension.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) mimeTypeFromExtension, (CharSequence) "video", false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) mimeTypeFromExtension, (CharSequence) "image", false, 2, (Object) null);
                if (contains$default2) {
                    guildAlbumMediaType = GuildAlbumMediaType.PHOTO;
                } else {
                    guildAlbumMediaType = GuildAlbumMediaType.OTHER;
                }
            } else {
                guildAlbumMediaType = GuildAlbumMediaType.VIDEO;
            }
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new GuildPickPhotoResult(false, filePath, guildAlbumMediaType, null, videoThumbPath, 9, null));
            i(mutableListOf);
            IQQGuildUIUtilApi iQQGuildUIUtilApi = (IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class);
            com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                bVar = null;
            }
            if (iQQGuildUIUtilApi.isInSplitViewMode(bVar.a().c().getActivity())) {
                com.tencent.aio.main.businesshelper.b bVar2 = this.helperParam;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                    bVar2 = null;
                }
                bVar2.a().e().h(new PanelMsg.HideAllPanelAndKeyboard("SendMsgFromCameraHelper", false, 2, null));
                return;
            }
            return;
        }
        QLog.e("SendMsgFromCameraHelper", 1, "send path: " + filePath + " illegal");
    }

    private final void e() {
        Intent intent;
        CoroutineScope f16;
        Bundle arguments;
        CoroutineScope f17;
        IQQGuildUIUtilApi iQQGuildUIUtilApi = (IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class);
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        if (iQQGuildUIUtilApi.isInSplitViewMode(bVar.a().c().getActivity())) {
            com.tencent.aio.main.businesshelper.b bVar2 = this.helperParam;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                bVar2 = null;
            }
            Fragment parentFragment = bVar2.a().c().getParentFragment();
            if (parentFragment != null && (arguments = parentFragment.getArguments()) != null && (f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e)) != null) {
                CorountineFunKt.e(f17, "SendMsgFromCameraHelper_onShow", Boolean.FALSE, null, null, new SendMsgFromCameraHelper$onShow$1(this, arguments, null), 12, null);
                return;
            }
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar3 = this.helperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar3 = null;
        }
        FragmentActivity activity = bVar3.a().c().getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent != null && (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e)) != null) {
            CorountineFunKt.e(f16, "SendMsgFromCameraHelper_onShow", Boolean.FALSE, null, null, new SendMsgFromCameraHelper$onShow$2(this, intent, null), 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Intent intent) {
        Object firstOrNull;
        if (intent.getBooleanExtra(PeakConstants.SEND_FLAG, false)) {
            intent.removeExtra(PeakConstants.SEND_FLAG);
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            if (stringArrayListExtra != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) stringArrayListExtra);
                String str = (String) firstOrNull;
                if (str != null) {
                    String stringExtra = intent.getStringExtra(PeakConstants.VIDEO_THUMBNAIL_PATH);
                    QLog.i("SendMsgFromCameraHelper", 1, "sendMediaMsg. send path: " + str + ", intent: " + intent.hashCode());
                    intent.removeExtra("PhotoConst.PHOTO_PATHS");
                    c(str, stringExtra);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Bundle args) {
        Object firstOrNull;
        if (args.getBoolean(PeakConstants.SEND_FLAG, false)) {
            args.remove(PeakConstants.SEND_FLAG);
            ArrayList<String> stringArrayList = args.getStringArrayList("PhotoConst.PHOTO_PATHS");
            if (stringArrayList != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) stringArrayList);
                String str = (String) firstOrNull;
                if (str != null) {
                    String string = args.getString(PeakConstants.VIDEO_THUMBNAIL_PATH);
                    QLog.i("SendMsgFromCameraHelper", 1, "sendMediaMsg. send path: " + str + ", args: " + args.hashCode());
                    args.remove("PhotoConst.PHOTO_PATHS");
                    c(str, string);
                }
            }
        }
    }

    private final void i(List<GuildPickPhotoResult> mediaList) {
        QLog.i(getTag(), 1, "sendMediaMsg " + mediaList);
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        bVar.a().e().h(new GuildMsgSendEvent.MediaSendEvent(mediaList, false, true));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 3;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return SendMsgFromCameraHelper.class.getSimpleName();
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{3};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.helperParam = param;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            e();
        }
    }
}
