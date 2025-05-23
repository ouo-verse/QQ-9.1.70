package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.luggage.wxa.f8.BlusherStickInfo;
import com.tencent.luggage.wxa.f8.EyeBrowInfo;
import com.tencent.luggage.wxa.f8.EyeShadowInfoV2;
import com.tencent.luggage.wxa.f8.FaceContourInfo;
import com.tencent.luggage.wxa.f8.LipStickInfoV1;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00072\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\b\u0007R\u0014\u0010\u0006\u001a\u00020\u00018&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\t\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/b;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/a;", "Lcom/tencent/luggage/wxa/f8/l;", "Lcom/tencent/luggage/wxa/f8/h;", "f", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/a;", "weEffectManager", "b", "a", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public interface b extends a, com.tencent.luggage.wxa.f8.l, com.tencent.luggage.wxa.f8.h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f146972c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000eH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0010H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\n\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\n\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u001c\u0010\n\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J \u0010\n\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eH\u0016J\u0012\u0010\n\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016R\u001a\u0010(\u001a\u00020$8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/b$a;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/b;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/a$e;", "type", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "stickerInfo", "Lorg/json/JSONObject;", com.tencent.luggage.wxa.c8.c.f123404x, "", "a", "Lcom/tencent/luggage/wxa/f8/p;", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/c;", "Lcom/tencent/luggage/wxa/f8/d;", "Lcom/tencent/luggage/wxa/f8/b;", "Lcom/tencent/luggage/wxa/f8/e;", "Lcom/tencent/luggage/wxa/f8/c;", "isEnabled", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/a$b;", "", "rate", "", "", "filePath", com.tencent.luggage.wxa.c8.c.f123400v, "c", "e", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/a$d;", "d", "", "p0", "p1", "p2", "", "g", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/a;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/a;", "f", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/a;", "weEffectManager", "<init>", "()V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion implements b {

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ Companion f146972c = new Companion();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final a weEffectManager;

        static {
            a DUMMY = a.f146954a;
            Intrinsics.checkNotNullExpressionValue(DUMMY, "DUMMY");
            weEffectManager = DUMMY;
        }

        Companion() {
        }

        @Override // com.tencent.luggage.wxa.f8.h
        public boolean a(@NotNull BlusherStickInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return false;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void c() {
            weEffectManager.c();
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void d() {
            weEffectManager.d();
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void e() {
            weEffectManager.e();
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b
        @NotNull
        public a f() {
            return weEffectManager;
        }

        public void g() {
            weEffectManager.onTextureDestoryed();
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public boolean isEnabled() {
            return weEffectManager.isEnabled();
        }

        @Override // com.tencent.luggage.wxa.f8.h
        public boolean a(@NotNull EyeBrowInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return false;
        }

        @Override // com.tencent.luggage.wxa.f8.h
        public boolean a(@NotNull EyeShadowInfoV2 info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return false;
        }

        @Override // com.tencent.luggage.wxa.f8.h
        public boolean a(@NotNull FaceContourInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return false;
        }

        @Override // com.tencent.luggage.wxa.f8.h
        public boolean a(@NotNull LipStickInfoV1 info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return false;
        }

        @Override // com.tencent.luggage.wxa.f8.h
        public boolean a(@NotNull LipStickInfoV2 info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return false;
        }

        @Override // com.tencent.luggage.wxa.f8.l
        public boolean a(@NotNull a.e type, @NotNull List<StickerItemInfo> stickerInfo, @Nullable JSONObject templateTransSet) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(stickerInfo, "stickerInfo");
            return false;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void a(@Nullable a.b type, float rate) {
            weEffectManager.a(type, rate);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void a(@Nullable String filePath, float alpha) {
            weEffectManager.a(filePath, alpha);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void a(@Nullable a.e type, @Nullable String filePath) {
            weEffectManager.a(type, filePath);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
        public void a(@Nullable a.d type, @Nullable String filePath) {
            weEffectManager.a(type, filePath);
        }

        public int a(int p06, int p16, int p26) {
            return weEffectManager.onTextureCustomProcess(p06, p16, p26);
        }

        public void a(@Nullable float[] p06) {
            weEffectManager.onDetectFacePoints(p06);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0003\u001a\u00020\u0002H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0005\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/b$b;", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/b;", OperateCustomButton.OPERATE_CREATE, "a", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC7005b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f146975b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/b$b$a;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/b$b;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/b$a;", "a", "<init>", "()V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b$b$a, reason: from kotlin metadata */
        /* loaded from: classes9.dex */
        public static final class Companion implements InterfaceC7005b {

            /* renamed from: b, reason: collision with root package name */
            static final /* synthetic */ Companion f146975b = new Companion();

            Companion() {
            }

            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b.InterfaceC7005b
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Companion create() {
                return b.INSTANCE;
            }
        }

        @NotNull
        b create();
    }

    @NotNull
    a f();
}
