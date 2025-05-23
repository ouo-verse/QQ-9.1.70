package com.tencent.mobileqq.wink.magicstudio.parts;

import android.app.Activity;
import android.os.Handler;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.bean.MediaType;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$jumpToPublishPage$3", f = "WinkMagicStudioResultButtonPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkMagicStudioResultButtonPart$jumpToPublishPage$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Pair<String, MediaType>> $paths;
    int label;
    final /* synthetic */ WinkMagicStudioResultButtonPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMagicStudioResultButtonPart$jumpToPublishPage$3(List<Pair<String, MediaType>> list, WinkMagicStudioResultButtonPart winkMagicStudioResultButtonPart, Continuation<? super WinkMagicStudioResultButtonPart$jumpToPublishPage$3> continuation) {
        super(2, continuation);
        this.$paths = list;
        this.this$0 = winkMagicStudioResultButtonPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List list, WinkMagicStudioResultButtonPart winkMagicStudioResultButtonPart) {
        MagicStudioPicStyle magicStudioPicStyle;
        JumpInfo jumpInfo;
        ArrayList<GenerateInfo> arrayList;
        MagicStudioCreationViewModel ga5;
        QUICheckBox qUICheckBox;
        Boolean bool;
        MagicStudioPicStyle magicStudioPicStyle2;
        String str;
        MagicStudioPicStyle magicStudioPicStyle3;
        String str2;
        String styleId;
        WinkMagicStudioLogicUtils winkMagicStudioLogicUtils = WinkMagicStudioLogicUtils.f323883a;
        Activity activity = winkMagicStudioResultButtonPart.getActivity();
        magicStudioPicStyle = winkMagicStudioResultButtonPart.magicStudioStyle;
        jumpInfo = winkMagicStudioResultButtonPart.jumpInfo;
        if (jumpInfo != null) {
            arrayList = jumpInfo.c();
        } else {
            arrayList = null;
        }
        ga5 = winkMagicStudioResultButtonPart.ga();
        int regenerateCount = ga5.getRegenerateCount();
        qUICheckBox = winkMagicStudioResultButtonPart.shareCheckbox;
        if (qUICheckBox != null) {
            bool = Boolean.valueOf(qUICheckBox.isChecked());
        } else {
            bool = null;
        }
        magicStudioPicStyle2 = winkMagicStudioResultButtonPart.magicStudioStyle;
        if (magicStudioPicStyle2 == null || (styleId = magicStudioPicStyle2.getStyleId()) == null) {
            str = "";
        } else {
            str = styleId;
        }
        magicStudioPicStyle3 = winkMagicStudioResultButtonPart.magicStudioStyle;
        if (magicStudioPicStyle3 == null || (str2 = magicStudioPicStyle3.getMaterialId()) == null) {
            str2 = "";
        }
        winkMagicStudioLogicUtils.k(list, activity, true, magicStudioPicStyle, arrayList, regenerateCount, bool, str, str2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkMagicStudioResultButtonPart$jumpToPublishPage$3(this.$paths, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int collectionSizeOrDefault;
        LocalMediaInfo c16;
        HashMap<String, Serializable> hashMapOf;
        HashMap<String, Serializable> hashMapOf2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<Pair<String, MediaType>> list = this.$paths;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            final ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (pair.getSecond() == MediaType.TypeVideo) {
                    c16 = ba3.a.d((String) pair.getFirst());
                    hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(AECameraConstants.MEDIA_FROM, AECameraConstants.MEDIA_FROM_EDIT));
                    c16.extData = hashMapOf2;
                } else {
                    c16 = ba3.a.c((String) pair.getFirst());
                    hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(AECameraConstants.MEDIA_FROM, AECameraConstants.MEDIA_FROM_EDIT));
                    c16.extData = hashMapOf;
                }
                arrayList.add(c16);
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkMagicStudioResultButtonPart winkMagicStudioResultButtonPart = this.this$0;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.i
                @Override // java.lang.Runnable
                public final void run() {
                    WinkMagicStudioResultButtonPart$jumpToPublishPage$3.b(arrayList, winkMagicStudioResultButtonPart);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkMagicStudioResultButtonPart$jumpToPublishPage$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
