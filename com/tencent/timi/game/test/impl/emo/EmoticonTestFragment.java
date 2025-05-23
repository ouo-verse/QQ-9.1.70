package com.tencent.timi.game.test.impl.emo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.timi.game.base.TimiGameBaseFragment;
import com.tencent.timi.game.test.impl.emo.EmoticonTestFragment$emojiEditableFactory$2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import nr2.az;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b*\u0001)\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/timi/game/test/impl/emo/EmoticonTestFragment;", "Lcom/tencent/timi/game/base/TimiGameBaseFragment;", "", "initViews", "", "text", "Dh", "Bh", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/emoticonview/api/IEmoticonMainPanelService$PanelBuilder;", "Ah", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "emoticonInfo", "Jh", "info", "Eh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "isWrapContent", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getRootView", "Lnr2/az;", UserInfo.SEX_FEMALE, "Lnr2/az;", "binding", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "G", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "mPanel", "com/tencent/timi/game/test/impl/emo/EmoticonTestFragment$emojiEditableFactory$2$a", "H", "Lkotlin/Lazy;", "Ch", "()Lcom/tencent/timi/game/test/impl/emo/EmoticonTestFragment$emojiEditableFactory$2$a;", "emojiEditableFactory", "<init>", "()V", "I", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class EmoticonTestFragment extends TimiGameBaseFragment {

    /* renamed from: F, reason: from kotlin metadata */
    private az binding;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private IEmoticonMainPanel mPanel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy emojiEditableFactory;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/test/impl/emo/EmoticonTestFragment$c", "Lcom/tencent/mobileqq/emoticonview/EmoticonListProvider;", "", "hasBigEmotion", "onlySysAndEmoji", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelInfo;", "getEmotionPanelInfo", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements EmoticonListProvider {
        c() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonListProvider
        @NotNull
        public List<EmotionPanelInfo> getEmotionPanelInfo(boolean hasBigEmotion, boolean onlySysAndEmoji) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
            arrayList.add(new EmotionPanelInfo(4, 4, null));
            arrayList.add(new EmotionPanelInfo(11, 4, null));
            return arrayList;
        }
    }

    public EmoticonTestFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<EmoticonTestFragment$emojiEditableFactory$2.a>() { // from class: com.tencent.timi.game.test.impl.emo.EmoticonTestFragment$emojiEditableFactory$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/test/impl/emo/EmoticonTestFragment$emojiEditableFactory$2$a", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes26.dex */
            public static final class a extends Editable.Factory {
                a() {
                }

                @Override // android.text.Editable.Factory
                @NotNull
                public Editable newEditable(@Nullable CharSequence source) {
                    if (source instanceof QQTextBuilder) {
                        return (Editable) source;
                    }
                    return new QQTextBuilder(source, 3, 20);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        this.emojiEditableFactory = lazy;
    }

    private final IEmoticonMainPanelService.PanelBuilder Ah(AppRuntime appRuntime) {
        IEmoticonMainPanelService.PanelBuilder panelBuilder = ((IEmoticonMainPanelService) appRuntime.getRuntimeService(IEmoticonMainPanelService.class, "")).newBuilder(getContext(), 100004);
        panelBuilder.setStyleChange(true);
        panelBuilder.setCallBack(new b());
        panelBuilder.setEmoticonListProvider(new c());
        panelBuilder.setDisableMoreEmotionButton(true);
        Intrinsics.checkNotNullExpressionValue(panelBuilder, "panelBuilder");
        return panelBuilder;
    }

    private final void Bh() {
        if (this.mPanel != null) {
            return;
        }
        AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
        Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
        this.mPanel = Ah(appRuntime).create();
    }

    private final EmoticonTestFragment$emojiEditableFactory$2.a Ch() {
        return (EmoticonTestFragment$emojiEditableFactory$2.a) this.emojiEditableFactory.getValue();
    }

    private final String Dh(String text) {
        com.tencent.timi.game.utils.l.i("EmoticonTestFragment_", "text:" + text);
        if (text == null) {
            return "";
        }
        String encodeText = com.tencent.mobileqq.qqlive.widget.util.c.b(text);
        com.tencent.timi.game.utils.l.i("EmoticonTestFragment_", "encodeText:" + text);
        Intrinsics.checkNotNullExpressionValue(encodeText, "encodeText");
        return encodeText;
    }

    private final void Eh(EmoticonInfo info) {
        Object m476constructorimpl;
        AppRuntime waitAppRuntime;
        QBaseActivity qBaseActivity;
        if (info instanceof SystemAndEmojiEmoticonInfo) {
            try {
                Result.Companion companion = Result.INSTANCE;
                waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                qBaseActivity = getQBaseActivity();
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (qBaseActivity == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity ?: return");
            QBaseActivity qBaseActivity2 = getQBaseActivity();
            az azVar = this.binding;
            if (azVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                azVar = null;
            }
            info.send(waitAppRuntime, qBaseActivity2, azVar.f420959d, null);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                com.tencent.timi.game.utils.l.e("EmoticonTestFragment_", String.valueOf(Result.m479exceptionOrNullimpl(m476constructorimpl)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(EmoticonTestFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Bh();
        az azVar = this$0.binding;
        az azVar2 = null;
        if (azVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            azVar = null;
        }
        azVar.f420961f.removeAllViews();
        az azVar3 = this$0.binding;
        if (azVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            azVar2 = azVar3;
        }
        FrameLayout frameLayout = azVar2.f420961f;
        IEmoticonMainPanel iEmoticonMainPanel = this$0.mPanel;
        Intrinsics.checkNotNull(iEmoticonMainPanel);
        frameLayout.addView(iEmoticonMainPanel.getView());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(EmoticonTestFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IEmoticonMainPanel iEmoticonMainPanel = this$0.mPanel;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onPullDown();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(EmoticonTestFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IEmoticonMainPanel iEmoticonMainPanel = this$0.mPanel;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onShow();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(EmoticonTestFragment this$0, View view) {
        String str;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        az azVar = this$0.binding;
        az azVar2 = null;
        if (azVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            azVar = null;
        }
        Editable editableText = azVar.f420959d.getEditableText();
        if (editableText != null) {
            str = editableText.toString();
        } else {
            str = null;
        }
        String Dh = this$0.Dh(str);
        if (Dh.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String a16 = com.tencent.mobileqq.qqlive.widget.util.c.a(Dh);
            Intrinsics.checkNotNullExpressionValue(a16, "decodeQQEmotion(finalSendText)");
            az azVar3 = this$0.binding;
            if (azVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                azVar3 = null;
            }
            azVar3.f420966k.setText(new QQText(a16, 3, 20));
        }
        az azVar4 = this$0.binding;
        if (azVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            azVar2 = azVar4;
        }
        Editable editableText2 = azVar2.f420959d.getEditableText();
        if (editableText2 != null) {
            editableText2.clear();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(EmoticonInfo emoticonInfo) {
        Drawable bigDrawable = emoticonInfo.getBigDrawable(getContext(), getQBaseActivity().getResources().getDisplayMetrics().density);
        if (bigDrawable == null) {
            com.tencent.timi.game.utils.l.e("EmoticonTestFragment_", "drawable of " + emoticonInfo + " is null");
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        URLImageView uRLImageView = new URLImageView(getContext());
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        uRLImageView.setImageDrawable(bigDrawable);
        az azVar = this.binding;
        if (azVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            azVar = null;
        }
        azVar.f420960e.addView(uRLImageView, layoutParams);
        com.tencent.timi.game.utils.l.i("EmoticonTestFragment_", "onSend drawable:" + bigDrawable);
        Eh(emoticonInfo);
    }

    private final void initViews() {
        az azVar = this.binding;
        az azVar2 = null;
        if (azVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            azVar = null;
        }
        azVar.f420958c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.test.impl.emo.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoticonTestFragment.Fh(EmoticonTestFragment.this, view);
            }
        });
        az azVar3 = this.binding;
        if (azVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            azVar3 = null;
        }
        azVar3.f420957b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.test.impl.emo.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoticonTestFragment.Gh(EmoticonTestFragment.this, view);
            }
        });
        az azVar4 = this.binding;
        if (azVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            azVar4 = null;
        }
        azVar4.f420962g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.test.impl.emo.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoticonTestFragment.Hh(EmoticonTestFragment.this, view);
            }
        });
        az azVar5 = this.binding;
        if (azVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            azVar5 = null;
        }
        azVar5.f420965j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.test.impl.emo.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoticonTestFragment.Ih(EmoticonTestFragment.this, view);
            }
        });
        az azVar6 = this.binding;
        if (azVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            azVar2 = azVar6;
        }
        azVar2.f420959d.setEditableFactory(Ch());
    }

    @Override // com.tencent.timi.game.base.TimiGameBaseFragment
    @Nullable
    public ViewGroup getRootView() {
        az azVar = this.binding;
        if (azVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            azVar = null;
        }
        return azVar.f420964i;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        az g16 = az.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        FrameLayout root = g16.getRoot();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IEmoticonMainPanel iEmoticonMainPanel = this.mPanel;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onDestory();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        IEmoticonMainPanel iEmoticonMainPanel = this.mPanel;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IEmoticonMainPanel iEmoticonMainPanel = this.mPanel;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        initViews();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/timi/game/test/impl/emo/EmoticonTestFragment$b", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements EmoticonCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "emoticonMall");
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(@Nullable EmoticonInfo info) {
            String str;
            if (info != null) {
                str = m.a(info);
            } else {
                str = null;
            }
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "onHidePopup info:" + str + "}");
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo info) {
            String str;
            if (info != null) {
                str = m.a(info);
            } else {
                str = null;
            }
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "onLongClick " + str);
            if (info != null) {
                EmoticonTestFragment.this.Jh(info);
                return true;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
            String str;
            String str2 = null;
            if (oldInfo != null) {
                str = m.a(oldInfo);
            } else {
                str = null;
            }
            if (newInfo != null) {
                str2 = m.a(newInfo);
            }
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "onShowPopup oldInfo:" + str + ", newInfo:" + str2);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(@Nullable EmoticonInfo info) {
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "send " + (info != null ? m.a(info) : null));
            if (info != null) {
                EmoticonTestFragment.this.Jh(info);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "setting");
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "send()}");
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
        }
    }
}
