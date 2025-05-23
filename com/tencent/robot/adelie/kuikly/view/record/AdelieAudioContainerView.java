package com.tencent.robot.adelie.kuikly.view.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.kuikly.module.AdelieTtsRecordParam;
import com.tencent.robot.adelie.kuikly.module.KuiklyRenderCallbackData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u00012\u00020\u0002:\u0001\u001bB'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\u0015\u00a2\u0006\u0004\b0\u00101J=\u0010\f\u001a\u00020\b*'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011J3\u0010\u0014\u001a\u00020\b2+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\tJ\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\nH\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010#RC\u0010&\u001a/\u0012)\u0012'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\t\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00063"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/view/record/AdelieAudioContainerView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/robot/adelie/kuikly/view/record/e;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "", "data", "c", "Lcom/tencent/robot/adelie/kuikly/view/record/f;", "callback", "setAbnormalCallback", "d", "Lcom/tencent/robot/adelie/kuikly/module/n;", "recordParam", "e", "f", "", "level", "b", "onRecorderEnd", "errCode", "errMsg", "a", "Lcom/tencent/robot/adelie/kuikly/view/record/AdelieAudioVolumeWaveView;", "Lcom/tencent/robot/adelie/kuikly/view/record/AdelieAudioVolumeWaveView;", "volumeWaveView", "Lcom/tencent/robot/adelie/kuikly/view/record/AdelieVoiceRecorder;", "Lcom/tencent/robot/adelie/kuikly/view/record/AdelieVoiceRecorder;", "audioRecorder", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "recordListener", h.F, "weakKuiklyCallback", "", "i", "Z", "isInitRecord", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieAudioContainerView extends RelativeLayout implements e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieAudioVolumeWaveView volumeWaveView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AdelieVoiceRecorder audioRecorder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<f> recordListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Function1<Object, Unit>> weakKuiklyCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isInitRecord;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieAudioContainerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c(Function1<Object, Unit> function1, String str) {
        if (function1 != null) {
            function1.invoke(new Gson().toJson(new KuiklyRenderCallbackData(true, str, null, 4, null)));
        }
    }

    @Override // com.tencent.robot.adelie.kuikly.view.record.e
    public void a(int errCode, @NotNull String errMsg) {
        f fVar;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        WeakReference<f> weakReference = this.recordListener;
        if (weakReference != null && (fVar = weakReference.get()) != null) {
            fVar.a(errCode, errMsg);
        }
    }

    @Override // com.tencent.robot.adelie.kuikly.view.record.e
    public void b(int level) {
        AdelieAudioVolumeWaveView adelieAudioVolumeWaveView = this.volumeWaveView;
        if (adelieAudioVolumeWaveView != null) {
            adelieAudioVolumeWaveView.c(level);
        }
    }

    public final void d() {
        this.audioRecorder.o();
        this.recordListener = null;
        this.isInitRecord = false;
    }

    public final void e(@NotNull AdelieTtsRecordParam recordParam) {
        Intrinsics.checkNotNullParameter(recordParam, "recordParam");
        if (!this.isInitRecord) {
            QLog.d("AdelieAudioContainerView", 1, "startRecord init param: " + recordParam);
            this.audioRecorder.j(recordParam);
        }
        this.isInitRecord = true;
        this.audioRecorder.n(recordParam);
    }

    public final void f(@Nullable Function1<Object, Unit> callback) {
        this.weakKuiklyCallback = new WeakReference<>(callback);
        this.audioRecorder.o();
    }

    @Override // com.tencent.robot.adelie.kuikly.view.record.e
    public void onRecorderEnd() {
        Function1<Object, Unit> function1;
        AdelieAudioVolumeWaveView adelieAudioVolumeWaveView = this.volumeWaveView;
        if (adelieAudioVolumeWaveView != null) {
            adelieAudioVolumeWaveView.b();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("duration", this.audioRecorder.getCurRecordTime());
        jSONObject.put("filePath", this.audioRecorder.getWavFilePath());
        WeakReference<Function1<Object, Unit>> weakReference = this.weakKuiklyCallback;
        if (weakReference != null && (function1 = weakReference.get()) != null) {
            c(function1, jSONObject.toString());
        }
    }

    public final void setAbnormalCallback(@NotNull f callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.recordListener = new WeakReference<>(callback);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieAudioContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieAudioContainerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieAudioContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.audioRecorder = new AdelieVoiceRecorder();
        View.inflate(context, R.layout.drp, this);
        this.volumeWaveView = (AdelieAudioVolumeWaveView) findViewById(R.id.sx_);
        this.audioRecorder.m(this);
    }
}
