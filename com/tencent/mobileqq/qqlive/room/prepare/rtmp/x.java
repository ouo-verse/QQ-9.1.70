package com.tencent.mobileqq.qqlive.room.prepare.rtmp;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/x;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqlive/room/prepare/x;", "data", "", "C9", "", "isPushing", "Landroid/text/SpannableStringBuilder;", "A9", "", "text", "z9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "rtmpUrlTextView", "e", "keyTextView", "f", "streamStateTextView", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", tl.h.F, "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "viewModel", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class x extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView rtmpUrlTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView keyTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView streamStateTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.room.prepare.k viewModel;

    public x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final SpannableStringBuilder A9(boolean isPushing) {
        String string;
        String str;
        int i3;
        Resources resources = getActivity().getResources();
        if (isPushing) {
            string = resources.getString(R.string.f211005jn);
            str = "activity.resources.getSt\u2026ring.qqlive_rtmp_pushing)";
        } else {
            string = resources.getString(R.string.f210995jm);
            str = "activity.resources.getSt\u2026qqlive_rtmp_no_push_info)";
        }
        Intrinsics.checkNotNullExpressionValue(string, str);
        if (isPushing) {
            i3 = -16711936;
        } else {
            i3 = SupportMenu.CATEGORY_MASK;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), 0, 2, 34);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(x this$0, com.tencent.mobileqq.qqlive.room.prepare.x xVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C9(xVar);
    }

    private final void C9(com.tencent.mobileqq.qqlive.room.prepare.x data) {
        if (data != null) {
            TextView textView = this.rtmpUrlTextView;
            if (textView != null) {
                textView.setText(data.f272085a);
            }
            TextView textView2 = this.keyTextView;
            if (textView2 != null) {
                textView2.setText(data.f272086b);
            }
            Unit unit = null;
            if (data.f272087c) {
                TextView textView3 = this.streamStateTextView;
                if (textView3 != null) {
                    textView3.setText(A9(true));
                    unit = Unit.INSTANCE;
                }
            } else {
                TextView textView4 = this.streamStateTextView;
                if (textView4 != null) {
                    textView4.setText(A9(false));
                    unit = Unit.INSTANCE;
                }
            }
            if (unit != null) {
                return;
            }
        }
        TextView textView5 = this.streamStateTextView;
        if (textView5 != null) {
            textView5.setText(A9(false));
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final void z9(String text) {
        Object obj;
        Activity activity = getActivity();
        if (activity != null) {
            obj = activity.getSystemService("clipboard");
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) obj, ClipData.newPlainText(null, text));
        QQToast.makeText(getActivity(), getActivity().getResources().getString(R.string.f210985jl), 1).show();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQLiveRtmpPrepareRtmpInfoPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            CharSequence charSequence = null;
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f641335e) {
                TextView textView = this.rtmpUrlTextView;
                if (textView != null) {
                    charSequence = textView.getText();
                }
                z9(String.valueOf(charSequence));
            } else if (num != null && num.intValue() == R.id.f641835j) {
                TextView textView2 = this.keyTextView;
                if (textView2 != null) {
                    charSequence = textView2.getText();
                }
                z9(String.valueOf(charSequence));
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        TextView textView;
        TextView textView2;
        MutableLiveData<com.tencent.mobileqq.qqlive.room.prepare.x> mutableLiveData;
        View findViewById;
        View findViewById2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        TextView textView3 = null;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f641235d);
        } else {
            textView = null;
        }
        this.rtmpUrlTextView = textView;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.f641735i);
        } else {
            textView2 = null;
        }
        this.keyTextView = textView2;
        if (rootView != null) {
            textView3 = (TextView) rootView.findViewById(R.id.f642035l);
        }
        this.streamStateTextView = textView3;
        if (rootView != null && (findViewById2 = rootView.findViewById(R.id.f641335e)) != null) {
            findViewById2.setOnClickListener(this);
        }
        if (rootView != null && (findViewById = rootView.findViewById(R.id.f641835j)) != null) {
            findViewById.setOnClickListener(this);
        }
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = (com.tencent.mobileqq.qqlive.room.prepare.k) new ViewModelProvider(getHostFragment(), com.tencent.mobileqq.qqlive.room.prepare.k.U).get(com.tencent.mobileqq.qqlive.room.prepare.k.class);
        this.viewModel = kVar;
        if (kVar != null && (mutableLiveData = kVar.K) != null) {
            mutableLiveData.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    x.B9(x.this, (com.tencent.mobileqq.qqlive.room.prepare.x) obj);
                }
            });
        }
    }
}
