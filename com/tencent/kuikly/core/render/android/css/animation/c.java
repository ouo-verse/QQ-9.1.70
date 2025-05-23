package com.tencent.kuikly.core.render.android.css.animation;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\"\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b1\u00102JH\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000226\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004H&J\b\u0010\u000e\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0004R\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010&\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010/\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010!\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R\u0014\u00100\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010#\u00a8\u00063"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/c;", "", "Landroid/view/View;", "target", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", IXWebBroadcastListener.STAGE_FINISHED, "", "propKey", "", "onAnimationEndBlock", "o", "a", "isCancel", "e", "", UserInfo.SEX_FEMALE, "c", "()F", "j", "(F)V", "durationS", "b", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "k", "(Ljava/lang/Object;)V", "finalValue", "i", "delay", "Z", tl.h.F, "()Z", DomainData.DOMAIN_NAME, "(Z)V", "repeatForever", "Ljava/lang/String;", "g", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "f", "getForceNotCancel", "l", "forceNotCancel", QzoneWebMusicJsPlugin.EVENT_PLAYING, "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float durationS;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object finalValue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float delay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean repeatForever;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String propKey = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean forceNotCancel;

    public abstract void a();

    /* renamed from: b, reason: from getter */
    public final float getDelay() {
        return this.delay;
    }

    /* renamed from: c, reason: from getter */
    public final float getDurationS() {
        return this.durationS;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Object getFinalValue() {
        return this.finalValue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean e(boolean isCancel) {
        if (this.forceNotCancel || !isCancel) {
            return true;
        }
        return false;
    }

    public abstract boolean f();

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getPropKey() {
        return this.propKey;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getRepeatForever() {
        return this.repeatForever;
    }

    public final void i(float f16) {
        this.delay = f16;
    }

    public final void j(float f16) {
        this.durationS = f16;
    }

    public final void k(@Nullable Object obj) {
        this.finalValue = obj;
    }

    public final void l(boolean z16) {
        this.forceNotCancel = z16;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.propKey = str;
    }

    public final void n(boolean z16) {
        this.repeatForever = z16;
    }

    public abstract void o(@NotNull View target, @NotNull Function2<? super Boolean, ? super String, Unit> onAnimationEndBlock);
}
