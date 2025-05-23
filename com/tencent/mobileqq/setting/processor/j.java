package com.tencent.mobileqq.setting.processor;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010-\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b.\u0010/J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R?\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010#\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/setting/processor/j;", "Lcom/tencent/mobileqq/setting/processor/c;", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "g", "Ljava/lang/CharSequence;", "leftText", "", tl.h.F, "I", "leftIcon", "Lkotlin/Function0;", "", "i", "Lkotlin/jvm/functions/Function0;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lkotlin/jvm/functions/Function0;)V", NodeProps.ON_CLICK, "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "j", "Lkotlin/jvm/functions/Function1;", "getOnExposure", "()Lkotlin/jvm/functions/Function1;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlin/jvm/functions/Function1;)V", "onExposure", "", "k", "Z", "getVisible", "()Z", "B", "(Z)V", NodeProps.VISIBLE, "l", "firstExposure", "Landroid/content/Context;", "context", "type", "<init>", "(Landroid/content/Context;ILjava/lang/CharSequence;I)V", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence leftText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int leftIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> onClick;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super View, Unit> onExposure;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean visible;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean firstExposure;

    public /* synthetic */ j(Context context, int i3, CharSequence charSequence, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i3, charSequence, (i17 & 8) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), charSequence, Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onClick;
        if (function0 != null) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(j this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.firstExposure) {
            this$0.firstExposure = false;
            Function1<? super View, Unit> function1 = this$0.onExposure;
            if (function1 != null) {
                function1.invoke(it);
            }
        }
    }

    public final void A(@Nullable Function1<? super View, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) function1);
        } else {
            this.onExposure = function1;
        }
    }

    public final void B(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.visible = z16;
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    @NotNull
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        x.b dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.widget.listitem.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        int i3 = this.leftIcon;
        if (i3 != 0) {
            dVar = new x.b.C8996b(this.leftText, i3);
        } else {
            dVar = new x.b.d(this.leftText);
        }
        x xVar = new x(dVar, new x.c.g("", true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.processor.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.x(j.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.processor.i
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                j.y(j.this, view);
            }
        });
        xVar.p(this.visible);
        return xVar;
    }

    public final void z(@Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) function0);
        } else {
            this.onClick = function0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull Context context, int i3, @NotNull CharSequence leftText, int i16) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), leftText, Integer.valueOf(i16));
            return;
        }
        this.leftText = leftText;
        this.leftIcon = i16;
        this.visible = true;
        this.firstExposure = true;
    }
}
