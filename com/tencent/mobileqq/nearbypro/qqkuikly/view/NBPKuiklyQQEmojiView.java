package com.tencent.mobileqq.nearbypro.qqkuikly.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import i01.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0007B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0017\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u001e\u0010\u001e\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001dR;\u0010&\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\f\u0018\u00010\u001fj\u0004\u0018\u0001`#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R;\u0010(\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\f\u0018\u00010\u001fj\u0004\u0018\u0001`#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/NBPKuiklyQQEmojiView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "Li01/c;", "", "propValue", "", "a", "c", "", "propKey", "b", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiUniversalPanel;", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiUniversalPanel;", "emojiPanel", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "e", "Lkotlin/jvm/functions/Function1;", "deleteEmojiCallback", "f", "addEmojiCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", h.F, "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBPKuiklyQQEmojiView extends FrameLayout implements EmoticonCallback, i01.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SystemAndEmojiUniversalPanel emojiPanel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> deleteEmojiCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> addEmojiCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPKuiklyQQEmojiView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        SystemAndEmojiUniversalPanel create = new SystemAndEmojiUniversalPanel.Builder(context).setEmoticonCallback(this).setShowCommonUsedSystemEmoji(true).create(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.peekAppRuntime()));
        this.emojiPanel = create;
        addView(create.getView(), new FrameLayout.LayoutParams(-1, -1));
    }

    private final boolean a(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.addEmojiCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    private final boolean c(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.deleteEmojiCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (Intrinsics.areEqual(propKey, "deleteEmojiCallback")) {
            return c(propValue);
        }
        if (Intrinsics.areEqual(propKey, "addEmojiCallback")) {
            return a(propValue);
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        Map emptyMap;
        Function1<Object, Unit> function1 = this.deleteEmojiCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
        this.emojiPanel.onDestroy();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public boolean onLongClick(@Nullable EmoticonInfo info) {
        return false;
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable String str2, @Nullable Function1<Object, Unit> function1) {
        return c.a.b(this, str, str2, function1);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(@Nullable EmoticonInfo info) {
        String emojiString;
        Map mapOf;
        Map mapOf2;
        if (info instanceof SystemEmoticonInfo) {
            Function1<Object, Unit> function1 = this.addEmojiCallback;
            if (function1 != null) {
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("emoji", QQSysFaceUtil.getFaceString(((SystemEmoticonInfo) info).code)));
                function1.invoke(mapOf2);
                return;
            }
            return;
        }
        if (info instanceof SystemAndEmojiEmoticonInfo) {
            SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) info;
            int i3 = systemAndEmojiEmoticonInfo.emotionType;
            int i16 = systemAndEmojiEmoticonInfo.code;
            if (i3 == 2 && i16 == -1) {
                return;
            }
            if (i3 == 1) {
                emojiString = TextUtils.getSysEmotcationString(i16);
            } else {
                emojiString = TextUtils.getEmojiString(i16);
            }
            Function1<Object, Unit> function12 = this.addEmojiCallback;
            if (function12 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("emoji", emojiString));
                function12.invoke(mapOf);
            }
            systemAndEmojiEmoticonInfo.addToCommonUsed(MobileQQ.sMobileQQ.peekAppRuntime(), (Parcelable) null);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onHidePopup(@Nullable EmoticonInfo info) {
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
    }
}
