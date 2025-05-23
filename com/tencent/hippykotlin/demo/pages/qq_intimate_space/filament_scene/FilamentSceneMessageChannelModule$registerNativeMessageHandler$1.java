package com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene;

import c45.i;
import com.tencent.kuikly.core.log.KLog;
import d25.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
/* loaded from: classes37.dex */
public final /* synthetic */ class FilamentSceneMessageChannelModule$registerNativeMessageHandler$1 extends FunctionReferenceImpl implements Function1<Object, Unit> {
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Object>>] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Object obj) {
        FilamentSceneMessageChannelModule filamentSceneMessageChannelModule = (FilamentSceneMessageChannelModule) this.receiver;
        filamentSceneMessageChannelModule.getClass();
        if (obj == null) {
            KLog.INSTANCE.e("FilamentSceneMessageChannelModule", "param is null");
        } else {
            byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
            if (bArr == null) {
                KLog.INSTANCE.e("FilamentSceneMessageChannelModule", "param is not ByteArray");
            } else {
                a aVar = (a) i.b(new a("", 4), bArr);
                String str = aVar.f392711e;
                if (str == null || str.length() == 0) {
                    KLog.INSTANCE.e("FilamentSceneMessageChannelModule", "eventName is empty");
                } else {
                    Function1 function1 = (Function1) filamentSceneMessageChannelModule.eventHandlerMap.get(str);
                    if (function1 != null) {
                        c45.a aVar2 = aVar.f392712f;
                        function1.invoke(aVar2 != null ? aVar2.f30291a : null);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    public FilamentSceneMessageChannelModule$registerNativeMessageHandler$1(Object obj) {
        super(1, obj, FilamentSceneMessageChannelModule.class, "onMessage", "onMessage(Ljava/lang/Object;)V", 0);
    }
}
