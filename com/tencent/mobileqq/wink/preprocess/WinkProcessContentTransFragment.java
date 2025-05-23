package com.tencent.mobileqq.wink.preprocess;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.context.p;
import com.tencent.mobileqq.wink.downloader.WinkQZoneMediaDownloader;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.q;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.wink.utils.am;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J)\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0013\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0002J&\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0002J\u0016\u0010\u0015\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J&\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00110.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/wink/preprocess/WinkProcessContentTransFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Gh", "", "missionId", "Lh", "textContent", "", "mediaPaths", "fromPart", "Jh", "Landroid/view/View;", "view", "Dh", "Kh", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "Ih", "Eh", "Fh", "reason", "Ah", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/m;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Ch", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/m;", "nextStepUIStateViewModel", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "D", "Bh", "()Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "", "E", "Ljava/util/List;", "selectedMedia", "Lcom/tencent/mobileqq/wink/context/p;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/context/p;", "winkCurrentContextBuilder", "<init>", "()V", "H", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkProcessContentTransFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy nextStepUIStateViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy nextStepHelper;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> selectedMedia;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final p winkCurrentContextBuilder;

    @NotNull
    public Map<Integer, View> G = new LinkedHashMap();

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/preprocess/WinkProcessContentTransFragment$b", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPickerNextStepDialogPart$a;", "", "onCancelClick", "", "b", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkMediaPickerNextStepDialogPart.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        @NotNull
        public List<LocalMediaInfo> a() {
            return WinkProcessContentTransFragment.this.selectedMedia;
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public boolean b() {
            return WinkProcessContentTransFragment.this.Bh().isRunning.get();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public void onCancelClick() {
            WinkProcessContentTransFragment.this.Bh().f();
            FragmentActivity activity = WinkProcessContentTransFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public WinkProcessContentTransFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.picker.core.viewmodel.m>() { // from class: com.tencent.mobileqq.wink.preprocess.WinkProcessContentTransFragment$nextStepUIStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.picker.core.viewmodel.m invoke() {
                return q.e(WinkProcessContentTransFragment.this);
            }
        });
        this.nextStepUIStateViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPickerNextStepHelper>() { // from class: com.tencent.mobileqq.wink.preprocess.WinkProcessContentTransFragment$nextStepHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkMediaPickerNextStepHelper invoke() {
                com.tencent.mobileqq.wink.picker.core.viewmodel.m Ch;
                Ch = WinkProcessContentTransFragment.this.Ch();
                return new WinkMediaPickerNextStepHelper(Ch);
            }
        });
        this.nextStepHelper = lazy2;
        this.selectedMedia = new ArrayList();
        this.winkCurrentContextBuilder = new p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah(String reason) {
        w53.b.f("WinkProcessContentTransFragment", "exit: " + reason);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkMediaPickerNextStepHelper Bh() {
        return (WinkMediaPickerNextStepHelper) this.nextStepHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.picker.core.viewmodel.m Ch() {
        return (com.tencent.mobileqq.wink.picker.core.viewmodel.m) this.nextStepUIStateViewModel.getValue();
    }

    private final void Dh(View view) {
        PartManager partManager = new PartManager(this, view);
        WinkMediaPickerNextStepDialogPart winkMediaPickerNextStepDialogPart = new WinkMediaPickerNextStepDialogPart(new b(), false, 2, null);
        winkMediaPickerNextStepDialogPart.setEnvironment(this, view, partManager);
        winkMediaPickerNextStepDialogPart.L9(this);
        winkMediaPickerNextStepDialogPart.onInitView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh(String textContent, List<String> mediaPaths) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new WinkProcessContentTransFragment$jumpToDailySignWithResource$1(mediaPaths, textContent, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh(List<? extends LocalMediaInfo> media) {
        final FragmentActivity activity = getActivity();
        if (activity != null) {
            WinkMediaPickerNextStepHelper.i(Bh(), activity, TabType.ALL_MEDIA, media, false, null, null, new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.preprocess.WinkProcessContentTransFragment$jumpToEditor$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MediaPickerOutput mediaPickerOutput) {
                    invoke2(mediaPickerOutput);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull MediaPickerOutput it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    FragmentActivity.this.getIntent().removeExtra(QQWinkConstants.EDITOR_TEXT_CONTENT);
                    FragmentActivity.this.getIntent().putExtra(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
                    FragmentActivity fragmentActivity = FragmentActivity.this;
                    Intrinsics.checkNotNullExpressionValue(fragmentActivity, "this");
                    Intent intent = FragmentActivity.this.getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "intent");
                    com.tencent.mobileqq.wink.picker.g.d(fragmentActivity, intent, it);
                    this.Ah("[processMedia] jump to editor");
                }
            }, 48, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh() {
        ArrayList<String> arrayList;
        String str;
        boolean z16;
        Intent intent;
        Bundle extras;
        Intent intent2;
        Bundle extras2;
        Intent intent3;
        Bundle extras3;
        FragmentActivity activity = getActivity();
        String str2 = null;
        if (activity != null && (intent3 = activity.getIntent()) != null && (extras3 = intent3.getExtras()) != null) {
            arrayList = extras3.getStringArrayList(QQWinkConstants.EDITOR_MEDIA_PATH_ARRAY_LIST);
        } else {
            arrayList = null;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent2 = activity2.getIntent()) != null && (extras2 = intent2.getExtras()) != null) {
            str = extras2.getString(QQWinkConstants.EDITOR_TEXT_CONTENT);
        } else {
            str = null;
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent = activity3.getIntent()) != null && (extras = intent.getExtras()) != null) {
            str2 = extras.getString(QQWinkConstants.ENTRY_BUSINESS_PART_NAME);
        }
        boolean z17 = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Jh(str, arrayList, str2);
            return;
        }
        if (str == null || str.length() == 0) {
            z17 = true;
        }
        if (!z17) {
            Eh(str, arrayList);
        } else {
            getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.preprocess.d
                @Override // java.lang.Runnable
                public final void run() {
                    WinkProcessContentTransFragment.Hh(WinkProcessContentTransFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(WinkProcessContentTransFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.requireContext() != null) {
            QQToast.makeText(this$0.requireContext(), HardCodeUtil.qqStr(R.string.f216515yi), 0).show();
        }
        this$0.Ah("invalid mediaPaths and textContent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih(List<? extends LocalMediaInfo> media) {
        ArrayList<LocalMediaInfo> arrayList = new ArrayList();
        for (Object obj : media) {
            if (e93.i.F((LocalMediaInfo) obj)) {
                arrayList.add(obj);
            }
        }
        for (LocalMediaInfo localMediaInfo : arrayList) {
            am amVar = am.f326679a;
            String str = localMediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(str, "it.path");
            String a16 = amVar.a(str);
            if (a16 != null) {
                localMediaInfo.path = a16;
                localMediaInfo.mMimeType = "image/jpeg";
            }
        }
    }

    private final void Jh(String textContent, List<String> mediaPaths, String fromPart) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new WinkProcessContentTransFragment$processMedia$1(this, mediaPaths, fromPart, textContent, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Kh(List<String> list, Continuation<? super List<String>> continuation) {
        WinkProcessContentTransFragment$processQZoneMedia$1 winkProcessContentTransFragment$processQZoneMedia$1;
        Object coroutine_suspended;
        int i3;
        WinkProcessContentTransFragment winkProcessContentTransFragment;
        boolean startsWith$default;
        Map map;
        int collectionSizeOrDefault;
        if (continuation instanceof WinkProcessContentTransFragment$processQZoneMedia$1) {
            winkProcessContentTransFragment$processQZoneMedia$1 = (WinkProcessContentTransFragment$processQZoneMedia$1) continuation;
            int i16 = winkProcessContentTransFragment$processQZoneMedia$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkProcessContentTransFragment$processQZoneMedia$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkProcessContentTransFragment$processQZoneMedia$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkProcessContentTransFragment$processQZoneMedia$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        list = (List) winkProcessContentTransFragment$processQZoneMedia$1.L$1;
                        winkProcessContentTransFragment = (WinkProcessContentTransFragment) winkProcessContentTransFragment$processQZoneMedia$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default((String) obj2, "http", false, 2, null);
                        if (startsWith$default) {
                            arrayList.add(obj2);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return list;
                    }
                    Ch().E0();
                    WinkQZoneMediaDownloader winkQZoneMediaDownloader = WinkQZoneMediaDownloader.f318202a;
                    winkProcessContentTransFragment$processQZoneMedia$1.L$0 = this;
                    winkProcessContentTransFragment$processQZoneMedia$1.L$1 = list;
                    winkProcessContentTransFragment$processQZoneMedia$1.label = 1;
                    obj = winkQZoneMediaDownloader.b(arrayList, winkProcessContentTransFragment$processQZoneMedia$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkProcessContentTransFragment = this;
                }
                map = (Map) obj;
                if (map != null) {
                    winkProcessContentTransFragment.Ch().b0(true);
                    w53.b.c("WinkProcessContentTransFragment", "downloadQZoneMedia failed");
                    return null;
                }
                winkProcessContentTransFragment.Ch().b0(false);
                List<String> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (String str : list2) {
                    String str2 = (String) map.get(str);
                    if (str2 != null) {
                        str = str2;
                    }
                    arrayList2.add(str);
                }
                return arrayList2;
            }
        }
        winkProcessContentTransFragment$processQZoneMedia$1 = new WinkProcessContentTransFragment$processQZoneMedia$1(this, continuation);
        Object obj3 = winkProcessContentTransFragment$processQZoneMedia$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkProcessContentTransFragment$processQZoneMedia$1.label;
        if (i3 == 0) {
        }
        map = (Map) obj3;
        if (map != null) {
        }
    }

    private final void Lh(String missionId) {
        w53.b.f("WinkProcessContentTransFragment", "[recoveryFromWinkEditData] missionId=" + missionId);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkProcessContentTransFragment$recoveryFromWinkEditData$1(missionId, this, null), 3, null);
    }

    public void _$_clearFindViewByIdCache() {
        this.G.clear();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        p pVar = this.winkCurrentContextBuilder;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        pVar.a(savedInstanceState, intent);
        Lh(WinkContext.INSTANCE.d().getMissionId());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.i78, container, false);
        Dh(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Intent intent;
        super.onResume();
        p pVar = this.winkCurrentContextBuilder;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        pVar.a(null, intent);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        this.winkCurrentContextBuilder.c(outState);
    }
}
