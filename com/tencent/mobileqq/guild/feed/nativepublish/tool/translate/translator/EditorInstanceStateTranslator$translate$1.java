package com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator;

import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class EditorInstanceStateTranslator$translate$1 extends FunctionReferenceImpl implements Function3<EditorInstanceStateTranslator, JSONObject, nm1.b, Unit> {
    public static final EditorInstanceStateTranslator$translate$1 INSTANCE = new EditorInstanceStateTranslator$translate$1();

    EditorInstanceStateTranslator$translate$1() {
        super(3, EditorInstanceStateTranslator.class, CanvasView.ACTION_TRANSLATE, "translate(Lorg/json/JSONObject;Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/TranslateInfo;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(EditorInstanceStateTranslator editorInstanceStateTranslator, JSONObject jSONObject, nm1.b bVar) {
        invoke2(editorInstanceStateTranslator, jSONObject, bVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull EditorInstanceStateTranslator p06, @NotNull JSONObject p16, @NotNull nm1.b p26) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        Intrinsics.checkNotNullParameter(p26, "p2");
        p06.a(p16, p26);
    }
}
