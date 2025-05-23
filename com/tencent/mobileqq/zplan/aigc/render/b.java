package com.tencent.mobileqq.zplan.aigc.render;

import android.os.Bundle;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.filament.light.data.FilamentRequestStatus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import eipc.EIPCResult;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\nB\u0013\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/b;", "Lrk0/a;", "Lcom/tencent/filament/light/data/a;", Const.BUNDLE_KEY_REQUEST, "Lrk0/b;", "callback", "", "e", "b", "Lcom/tencent/filament/light/data/b;", "a", "Lks/a;", "Lks/a;", "filamentDownloadListener", "<init>", "(Lks/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b implements rk0.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ks.a filamentDownloadListener;

    public b(ks.a aVar) {
        this.filamentDownloadListener = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b this$0, com.tencent.filament.light.data.a aVar, rk0.b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e(aVar, bVar);
    }

    private final void e(com.tencent.filament.light.data.a request, rk0.b callback) {
        ms.a.f("AEQQLightFilamentDownloader", "FilamentGetAvatarAsset");
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, String> hashMap = new HashMap<>();
        String str = request != null ? request.f105571c : null;
        if (str == null) {
            str = "";
        }
        if (Intrinsics.areEqual(str, "-1")) {
            str = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString("avatar_uni", str);
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IAECameraGetInfoServer.NAME, "ACTION_FILAMENT_GET_AVATAR_INFO", bundle);
        if ((callServer != null ? callServer.data : null) != null) {
            String string = callServer.data.getString("avatar_character_info_json_string");
            ms.a.f("AEQQLightFilamentDownloader", "FilamentGetAvatarAsset avatarInfoPath: " + string);
            hashMap.put("avatar_character_info_json_string", string != null ? string : "");
        }
        hashMap.put(IndividuationUrlHelper.UrlId.SUIT_HOME, "0");
        hashMap.put("qqUin", str);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        ms.a.f("AEQQLightFilamentDownloader", "FilamentGetAvatarAsset succ: " + currentTimeMillis2 + " ms");
        if (callback != null) {
            callback.a(hashMap, FilamentRequestStatus.SUCCESS);
        }
        ks.a aVar = this.filamentDownloadListener;
        if (aVar != null) {
            aVar.a("avatar_info", currentTimeMillis2);
        }
    }

    @Override // rk0.a
    public void a(com.tencent.filament.light.data.b request) {
        ms.a.f("AEQQLightFilamentDownloader", "FilamentDownloadDidCancel");
    }

    @Override // rk0.a
    public void b(final com.tencent.filament.light.data.a request, final rk0.b callback) {
        ks.a aVar = this.filamentDownloadListener;
        if (aVar != null) {
            aVar.j("avatar_info");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.render.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d(b.this, request, callback);
            }
        }, 128, null, false);
    }

    public /* synthetic */ b(ks.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aVar);
    }
}
