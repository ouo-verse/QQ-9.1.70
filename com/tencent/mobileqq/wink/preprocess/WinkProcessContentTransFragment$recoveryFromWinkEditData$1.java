package com.tencent.mobileqq.wink.preprocess;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.dailysign.DailySignConfig;
import com.tencent.mobileqq.wink.dailysign.af;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.preprocess.WinkProcessContentTransFragment$recoveryFromWinkEditData$1", f = "WinkProcessContentTransFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkProcessContentTransFragment$recoveryFromWinkEditData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $missionId;
    int label;
    final /* synthetic */ WinkProcessContentTransFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkProcessContentTransFragment$recoveryFromWinkEditData$1(String str, WinkProcessContentTransFragment winkProcessContentTransFragment, Continuation<? super WinkProcessContentTransFragment$recoveryFromWinkEditData$1> continuation) {
        super(2, continuation);
        this.$missionId = str;
        this.this$0 = winkProcessContentTransFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkProcessContentTransFragment$recoveryFromWinkEditData$1(this.$missionId, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Integer editMode;
        ArrayList<String> arrayList;
        String str;
        boolean z16;
        Intent intent;
        Bundle extras;
        Intent intent2;
        Bundle extras2;
        Bundle extras3;
        String tag;
        ArrayList<String> arrayList2;
        Intent intent3;
        Bundle extras4;
        Intent intent4;
        Bundle extras5;
        Bundle extras6;
        boolean z17;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            WinkEditDataWrapper c16 = com.tencent.mobileqq.wink.editor.draft.a.c(this.$missionId);
            if (c16 == null) {
                w53.b.f("WinkProcessContentTransFragment", "editData is null, try to use mediaPaths");
                this.this$0.Gh();
                return Unit.INSTANCE;
            }
            Integer from = c16.getFrom();
            String str2 = null;
            boolean z18 = false;
            if ((from == null || from.intValue() != 7) && (editMode = c16.getEditMode()) != null && editMode.intValue() == 1) {
                FragmentActivity activity = this.this$0.getActivity();
                if (activity != null && (intent2 = activity.getIntent()) != null && (extras2 = intent2.getExtras()) != null) {
                    arrayList = extras2.getStringArrayList(QQWinkConstants.EDITOR_MEDIA_PATH_ARRAY_LIST);
                } else {
                    arrayList = null;
                }
                FragmentActivity activity2 = this.this$0.getActivity();
                if (activity2 != null && (intent = activity2.getIntent()) != null && (extras = intent.getExtras()) != null) {
                    str = extras.getString(QQWinkConstants.ENTRY_BUSINESS_PART_NAME);
                } else {
                    str = null;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16 && arrayList.size() == 1 && QAlbumUtil.getMediaType(arrayList.get(0)) != 1 && Intrinsics.areEqual(QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_SHUOSHUO, str)) {
                    this.this$0.Gh();
                    return Unit.INSTANCE;
                }
            }
            ArrayList<LocalMediaInfo> originMediaInfos = c16.getOriginMediaInfos();
            if (originMediaInfos != null) {
                ArrayList arrayList3 = new ArrayList();
                Iterator<T> it = originMediaInfos.iterator();
                while (it.hasNext()) {
                    String str3 = ((LocalMediaInfo) it.next()).path;
                    if (str3 != null) {
                        arrayList3.add(str3);
                    }
                }
                if (!arrayList3.isEmpty()) {
                    Iterator it5 = arrayList3.iterator();
                    while (it5.hasNext()) {
                        if (!new File((String) it5.next()).exists()) {
                            z17 = true;
                            break;
                        }
                    }
                }
                z17 = false;
                if (z17) {
                    z18 = true;
                }
            }
            if (z18) {
                w53.b.f("WinkProcessContentTransFragment", "editData's originMediaInfos is not exist, try to use mediaPaths");
                this.this$0.Gh();
                return Unit.INSTANCE;
            }
            FragmentActivity activity3 = this.this$0.getActivity();
            if (activity3 != null) {
                WinkProcessContentTransFragment winkProcessContentTransFragment = this.this$0;
                String str4 = this.$missionId;
                Integer from2 = c16.getFrom();
                if (from2 != null && from2.intValue() == 7) {
                    try {
                        Bundle bundle = new Bundle();
                        Intent intent5 = activity3.getIntent();
                        if (intent5 != null && (extras6 = intent5.getExtras()) != null) {
                            bundle.putAll(extras6);
                        }
                        bundle.putString(WinkDTParamBuilder.APP_KEY_NAME, "00000QG6YX3X0LZH");
                        FragmentActivity activity4 = winkProcessContentTransFragment.getActivity();
                        if (activity4 != null && (intent4 = activity4.getIntent()) != null && (extras5 = intent4.getExtras()) != null) {
                            arrayList2 = extras5.getStringArrayList(QQWinkConstants.EDITOR_MEDIA_PATH_ARRAY_LIST);
                        } else {
                            arrayList2 = null;
                        }
                        FragmentActivity activity5 = winkProcessContentTransFragment.getActivity();
                        if (activity5 != null && (intent3 = activity5.getIntent()) != null && (extras4 = intent3.getExtras()) != null) {
                            str2 = extras4.getString(QQWinkConstants.EDITOR_TEXT_CONTENT);
                        }
                        DailySignConfig dailySignConfig = new DailySignConfig(new af(arrayList2, str2, str4));
                        dailySignConfig.setFrom("QZONE");
                        bundle.putSerializable(QQWinkConstants.EDITOR_TEXT_TEMPLATE_CONFIG, dailySignConfig);
                        com.tencent.mobileqq.wink.f.m(winkProcessContentTransFragment.requireContext(), bundle);
                    } catch (Exception e16) {
                        tag = winkProcessContentTransFragment.getTAG();
                        w53.b.d(tag, "recoveryFromWinkEditData fail", e16);
                    }
                    winkProcessContentTransFragment.Ah("[recoveryFromWinkEditData] jump to daily sign");
                } else {
                    Intent intent6 = new Intent(activity3, (Class<?>) QQWinkActivity.class);
                    Intent intent7 = activity3.getIntent();
                    if (intent7 != null && (extras3 = intent7.getExtras()) != null) {
                        intent6.putExtras(extras3);
                    }
                    intent6.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
                    activity3.startActivity(intent6);
                    winkProcessContentTransFragment.Ah("[recoveryFromWinkEditData] jump to editor");
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkProcessContentTransFragment$recoveryFromWinkEditData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
