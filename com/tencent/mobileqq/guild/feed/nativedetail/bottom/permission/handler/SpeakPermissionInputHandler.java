package com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler;

import android.util.SparseArray;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import fl1.b;
import fl1.c;
import fl1.d;
import fl1.e;
import fl1.f;
import fl1.g;
import fl1.h;
import fl1.i;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/SpeakPermissionInputHandler;", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "curSpeakPermission", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "", "c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "inputContext", "Landroid/util/SparseArray;", "Lfl1/a;", "b", "Lkotlin/Lazy;", "()Landroid/util/SparseArray;", "processList", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SpeakPermissionInputHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a inputContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy processList;

    public SpeakPermissionInputHandler(@NotNull a inputContext) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
        this.inputContext = inputContext;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SparseArray<fl1.a>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.SpeakPermissionInputHandler$processList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SparseArray<fl1.a> invoke() {
                a aVar;
                a aVar2;
                a aVar3;
                a aVar4;
                a aVar5;
                a aVar6;
                a aVar7;
                a aVar8;
                List<fl1.a> listOf;
                SparseArray<fl1.a> sparseArray = new SparseArray<>();
                SpeakPermissionInputHandler speakPermissionInputHandler = SpeakPermissionInputHandler.this;
                aVar = speakPermissionInputHandler.inputContext;
                aVar2 = speakPermissionInputHandler.inputContext;
                aVar3 = speakPermissionInputHandler.inputContext;
                aVar4 = speakPermissionInputHandler.inputContext;
                aVar5 = speakPermissionInputHandler.inputContext;
                aVar6 = speakPermissionInputHandler.inputContext;
                aVar7 = speakPermissionInputHandler.inputContext;
                aVar8 = speakPermissionInputHandler.inputContext;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new fl1.a[]{new c(aVar), new h(aVar2), new e(aVar3), new i(aVar4), new f(aVar5), new d(aVar6), new b(aVar7), new g(aVar8)});
                for (fl1.a aVar9 : listOf) {
                    sparseArray.put(aVar9.b().ordinal(), aVar9);
                }
                return sparseArray;
            }
        });
        this.processList = lazy;
    }

    private final SparseArray<fl1.a> b() {
        return (SparseArray) this.processList.getValue();
    }

    public final void c(@NotNull SpeakPermissionType curSpeakPermission, @NotNull ShowInputComponentArgs inputArgs) {
        Intrinsics.checkNotNullParameter(curSpeakPermission, "curSpeakPermission");
        Intrinsics.checkNotNullParameter(inputArgs, "inputArgs");
        fl1.a aVar = b().get(curSpeakPermission.ordinal());
        if (aVar != null) {
            aVar.c(inputArgs);
        }
    }
}
