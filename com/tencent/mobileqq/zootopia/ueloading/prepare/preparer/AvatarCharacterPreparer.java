package com.tencent.mobileqq.zootopia.ueloading.prepare.preparer;

import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2;
import com.tencent.mobileqq.zplan.dresskey.api.DressInfoIPCData;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vd3.PrepareErr;
import vd3.PrepareResult;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/prepare/preparer/AvatarCharacterPreparer;", "Lvd3/a;", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lorg/json/JSONObject;", "enterJson", "Lvd3/c;", "callback", "", "a", "", "e", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "ueLoader", "<init>", "(Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AvatarCharacterPreparer extends vd3.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarCharacterPreparer(ZPlanUELoaderControllerV2 ueLoader) {
        super(ueLoader);
        Intrinsics.checkNotNullParameter(ueLoader, "ueLoader");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final AvatarCharacterPreparer this$0, final vd3.c callback, final ZootopiaEnterParams enterParams, final JSONObject enterJson) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(enterParams, "$enterParams");
        Intrinsics.checkNotNullParameter(enterJson, "$enterJson");
        ((eh3.a) i.INSTANCE.a(eh3.a.class)).getDefaultAvatarCharacter(new eh3.b() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.AvatarCharacterPreparer$prepare$1$1
            @Override // eh3.b
            public void a(DressInfoIPCData maleAvatarCharacter, DressInfoIPCData femaleAvatarCharacter) {
                Intrinsics.checkNotNullParameter(maleAvatarCharacter, "maleAvatarCharacter");
                Intrinsics.checkNotNullParameter(femaleAvatarCharacter, "femaleAvatarCharacter");
                if (maleAvatarCharacter.getResultCode() == 0 && femaleAvatarCharacter.getResultCode() == 0) {
                    enterJson.put("MaleDefaultAvatarInfo", new JSONObject(maleAvatarCharacter.getInfoJson()));
                    enterJson.put("FemaleDefaultAvatarInfo", new JSONObject(femaleAvatarCharacter.getInfoJson()));
                    final AvatarCharacterPreparer avatarCharacterPreparer = AvatarCharacterPreparer.this;
                    final ZootopiaEnterParams zootopiaEnterParams = enterParams;
                    final JSONObject jSONObject = enterJson;
                    final vd3.c cVar = callback;
                    PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.AvatarCharacterPreparer$prepare$1$1$onGetDefaultAvatarCharacter$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            AvatarCharacterPreparer.this.f(zootopiaEnterParams, jSONObject, cVar);
                        }
                    });
                    com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.g(vd3.a.c(AvatarCharacterPreparer.this, false, System.currentTimeMillis() - AvatarCharacterPreparer.this.getStepStartTime(), 1, null), true);
                    return;
                }
                AvatarCharacterPreparer.this.g("maleAvatarCharacter.resultCode != 0 || femaleAvatarCharacter.resultCode != 0");
                callback.a(new PrepareResult(enterParams, enterJson, null, new PrepareErr(5, -100, "AvatarCharacter get failed  maleAvatarCharacter.resultCode = " + maleAvatarCharacter.getResultCode() + ",  femaleAvatarCharacter.resultCode = " + femaleAvatarCharacter.getResultCode()), 4, null));
                com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.g(vd3.a.c(AvatarCharacterPreparer.this, false, System.currentTimeMillis() - AvatarCharacterPreparer.this.getStepStartTime(), 1, null), false);
            }
        });
    }

    @Override // vd3.a, vd3.b
    public void a(final ZootopiaEnterParams enterParams, final JSONObject enterJson, final vd3.c callback) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(enterJson, "enterJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(enterParams, enterJson, callback);
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.f(vd3.a.c(this, false, 0L, 3, null));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.a
            @Override // java.lang.Runnable
            public final void run() {
                AvatarCharacterPreparer.k(AvatarCharacterPreparer.this, callback, enterParams, enterJson);
            }
        }, 16, null, true);
    }

    @Override // vd3.a
    public String e() {
        return "AvatarCharacterPreparer";
    }
}
