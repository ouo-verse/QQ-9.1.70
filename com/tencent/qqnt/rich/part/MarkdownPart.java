package com.tencent.qqnt.rich.part;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.android.androidbypass.enhance.i;
import com.tencent.android.androidbypass.parser.a;
import com.tencent.android.androidbypass.richui.c;
import com.tencent.android.androidbypass.viewgroup.d;
import com.tencent.android.androidbypass.viewgroup.f;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.rich.g;
import com.tencent.qqnt.rich.j;
import com.tencent.qqnt.rich.k;
import com.tencent.qqnt.rich.l;
import com.tencent.qqnt.rich.m;
import com.tencent.qqnt.rich.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 E2\u00020\u0001:\u0001\rB'\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010B\u001a\u00020A\u00a2\u0006\u0004\bC\u0010DJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R0\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020,0+j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020,`-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R$\u0010:\u001a\u0012\u0012\u0004\u0012\u00020605j\b\u0012\u0004\u0012\u000206`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006F"}, d2 = {"Lcom/tencent/qqnt/rich/part/MarkdownPart;", "Lcom/tencent/qqnt/rich/part/a;", "Landroid/view/View;", "view", "", NodeProps.MAX_WIDTH, "", "l", "Landroidx/constraintlayout/widget/ConstraintLayout;", ParseCommon.CONTAINER, "Lcom/tencent/qqnt/rich/j;", "richData", "", "a", "Landroid/widget/TextView;", "textView", "Lcom/tencent/qqnt/rich/p;", "textInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "action", "", "objects", "r0", "Lcom/tencent/qqnt/rich/g;", h.F, "Lcom/tencent/qqnt/rich/g;", "mOption", "Lcom/tencent/qqnt/rich/h;", "i", "Lcom/tencent/qqnt/rich/h;", "mMorphisOption", "Lcom/tencent/android/androidbypass/parser/a;", "Lkotlin/Lazy;", "j", "()Lcom/tencent/android/androidbypass/parser/a;", "mMarkdownParser", "Lcom/tencent/android/androidbypass/enhance/i;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/android/androidbypass/enhance/i;", "k", "()Lcom/tencent/android/androidbypass/enhance/i;", "mStyleSheet", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/markdown/b;", "Lkotlin/collections/HashMap;", "D", "Ljava/util/HashMap;", "renderList", "Lcom/tencent/qqnt/rich/b;", "E", "Lcom/tencent/qqnt/rich/b;", "cacheManager", "Ljava/util/ArrayList;", "Lcom/tencent/android/androidbypass/viewgroup/f;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "richElementGroupList", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/rich/m;", "helper", "Lcom/tencent/qqnt/rich/k;", "extParam", "Lcom/tencent/qqnt/rich/l;", "richFactory", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/rich/m;Lcom/tencent/qqnt/rich/k;Lcom/tencent/qqnt/rich/l;)V", "G", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class MarkdownPart extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final i mStyleSheet;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, com.tencent.qqnt.markdown.b> renderList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.rich.b cacheManager;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<f> richElementGroupList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g mOption;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.rich.h mMorphisOption;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMarkdownParser;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/rich/part/MarkdownPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.rich.part.MarkdownPart$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000M\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016JD\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0012H\u0016J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u0004H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016\u00a8\u0006\u001d"}, d2 = {"com/tencent/qqnt/rich/part/MarkdownPart$b", "Lcom/tencent/android/androidbypass/viewgroup/d;", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "f", "", "d", "", "getMaxWidth", "Lcom/tencent/android/androidbypass/richui/c;", "getRichUIFactory", "textView", "Landroid/text/SpannableStringBuilder;", "builder", "nodeType", "nodeId", "contentText", "Ljava/util/HashMap;", "attribute", "", "g", "Landroid/view/View;", "b", "view", "c", "e", "Lcom/tencent/android/androidbypass/richui/view/j;", "a", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f362036b;

        b(j jVar) {
            this.f362036b = jVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MarkdownPart.this, (Object) jVar);
            }
        }

        @Override // com.tencent.android.androidbypass.viewgroup.d
        @Nullable
        public com.tencent.android.androidbypass.richui.view.j a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (com.tencent.android.androidbypass.richui.view.j) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return MarkdownPart.this.mMorphisOption.b();
        }

        @Override // com.tencent.android.androidbypass.viewgroup.d
        @NotNull
        public View b(@NotNull Context context, @NotNull String nodeId, @NotNull String contentText) {
            View c16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (View) iPatchRedirector.redirect((short) 7, this, context, nodeId, contentText);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(nodeId, "nodeId");
            Intrinsics.checkNotNullParameter(contentText, "contentText");
            com.tencent.qqnt.markdown.data.b bVar = this.f362036b.a().b().get(nodeId);
            if (bVar != null) {
                j jVar = this.f362036b;
                MarkdownPart markdownPart = MarkdownPart.this;
                bVar.j(jVar.e());
                com.tencent.qqnt.markdown.a<?> g16 = bVar.g();
                if (g16 == null || (c16 = g16.c(context, bVar, markdownPart.cacheManager)) == null) {
                    return new View(context);
                }
                return c16;
            }
            return new View(context);
        }

        @Override // com.tencent.android.androidbypass.viewgroup.d
        public void c(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            } else {
                Intrinsics.checkNotNullParameter(view, "view");
                MarkdownPart.this.l(view, this.f362036b.e());
            }
        }

        @Override // com.tencent.android.androidbypass.viewgroup.d
        @NotNull
        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return MarkdownPart.this.mMorphisOption.a();
        }

        @Override // com.tencent.android.androidbypass.viewgroup.d
        public void e(@NotNull TextView textView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView);
            } else {
                Intrinsics.checkNotNullParameter(textView, "textView");
                MarkdownPart.this.m(textView, this.f362036b.e(), this.f362036b.d());
            }
        }

        @Override // com.tencent.android.androidbypass.viewgroup.d
        @NotNull
        public TextView f(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TextView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            return MarkdownPart.this.cacheManager.c(context);
        }

        @Override // com.tencent.android.androidbypass.viewgroup.d
        public void g(@NotNull TextView textView, @NotNull SpannableStringBuilder builder, @NotNull String nodeType, @NotNull String nodeId, @NotNull String contentText, @NotNull HashMap<String, String> attribute) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, textView, builder, nodeType, nodeId, contentText, attribute);
                return;
            }
            Intrinsics.checkNotNullParameter(textView, "textView");
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(nodeType, "nodeType");
            Intrinsics.checkNotNullParameter(nodeId, "nodeId");
            Intrinsics.checkNotNullParameter(contentText, "contentText");
            Intrinsics.checkNotNullParameter(attribute, "attribute");
            com.tencent.qqnt.markdown.b bVar = (com.tencent.qqnt.markdown.b) MarkdownPart.this.renderList.get(nodeType);
            if (bVar != null) {
                bVar.a(textView, builder, nodeId, this.f362036b.a().b(), attribute);
            }
        }

        @Override // com.tencent.android.androidbypass.viewgroup.d
        public int getMaxWidth() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f362036b.e();
        }

        @Override // com.tencent.android.androidbypass.viewgroup.d
        @NotNull
        public c getRichUIFactory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (c) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return MarkdownPart.this.d().a();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36464);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkdownPart(@NotNull Context context, @NotNull m helper, @NotNull k extParam, @NotNull l richFactory) {
        super(context, helper, extParam, richFactory);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(extParam, "extParam");
        Intrinsics.checkNotNullParameter(richFactory, "richFactory");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, helper, extParam, richFactory);
            return;
        }
        this.mOption = extParam.a();
        this.mMorphisOption = extParam.b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.android.androidbypass.parser.a>() { // from class: com.tencent.qqnt.rich.part.MarkdownPart$mMarkdownParser$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MarkdownPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.android.androidbypass.parser.a invoke() {
                g gVar;
                g gVar2;
                g gVar3;
                g gVar4;
                g gVar5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.android.androidbypass.parser.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                com.tencent.android.androidbypass.parser.d k3 = com.tencent.qqnt.markdown.g.f359430a.g().h(MarkdownPart.this.k()).k(com.tencent.qqnt.markdown.pic.h.f359445a);
                gVar = MarkdownPart.this.mOption;
                com.tencent.android.androidbypass.parser.d d16 = k3.d(gVar.d());
                gVar2 = MarkdownPart.this.mOption;
                com.tencent.android.androidbypass.parser.d e16 = d16.e(gVar2.e());
                gVar3 = MarkdownPart.this.mOption;
                com.tencent.android.androidbypass.parser.d c16 = e16.c(gVar3.a());
                gVar4 = MarkdownPart.this.mOption;
                com.tencent.android.androidbypass.parser.d f16 = c16.f(gVar4.b());
                gVar5 = MarkdownPart.this.mOption;
                return f16.g(gVar5.c()).b();
            }
        });
        this.mMarkdownParser = lazy;
        i iVar = new i();
        iVar.f72204t = false;
        int color = context.getColor(R.color.qui_common_bubble_guest_text_secondary);
        iVar.f72205u = color;
        int a16 = com.tencent.qqnt.rich.util.a.f362055a.a(color, 0.5f);
        iVar.f72206v = a16;
        iVar.N = false;
        iVar.P = a16;
        iVar.W = iVar.f72205u;
        float[] headerRelativeSizes = iVar.f72178b;
        Intrinsics.checkNotNullExpressionValue(headerRelativeSizes, "headerRelativeSizes");
        ArraysKt___ArraysJvmKt.fill$default(headerRelativeSizes, 1.0f, 0, 0, 6, (Object) null);
        iVar.f72184e = 6.0f;
        iVar.Z = 6.0f;
        this.mStyleSheet = iVar;
        HashMap<String, com.tencent.qqnt.markdown.b> hashMap = new HashMap<>();
        hashMap.put("refFootnotes", new com.tencent.qqnt.markdown.data.quote.c());
        this.renderList = hashMap;
        this.cacheManager = new com.tencent.qqnt.rich.b();
        this.richElementGroupList = new ArrayList<>();
    }

    private final com.tencent.android.androidbypass.parser.a j() {
        return (com.tencent.android.androidbypass.parser.a) this.mMarkdownParser.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(View view, int maxWidth) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        if (view.getLayoutParams() == null) {
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(maxWidth, -2);
            layoutParams.leftToLeft = 0;
            layoutParams.rightToRight = 0;
            if (c().b() < 0) {
                layoutParams.topToTop = 0;
            } else {
                layoutParams.topToBottom = c().b();
            }
            layoutParams.horizontalBias = 0.0f;
            view.setLayoutParams(layoutParams);
        } else {
            ConstraintLayout.LayoutParams layoutParams2 = null;
            if (!(view.getLayoutParams() instanceof ConstraintLayout.LayoutParams)) {
                int i3 = view.getLayoutParams().height;
                int i16 = view.getLayoutParams().width;
                Rect rect = new Rect();
                ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                } else {
                    marginLayoutParams = null;
                }
                if (marginLayoutParams != null) {
                    rect.top = marginLayoutParams.topMargin;
                    rect.left = marginLayoutParams.leftMargin;
                    rect.right = marginLayoutParams.rightMargin;
                    rect.bottom = marginLayoutParams.bottomMargin;
                }
                ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(i16, i3);
                ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = rect.top;
                ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = rect.left;
                ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = rect.bottom;
                ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = rect.right;
                view.setLayoutParams(layoutParams4);
            }
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            if (layoutParams5 instanceof ConstraintLayout.LayoutParams) {
                layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams5;
            }
            if (layoutParams2 != null) {
                layoutParams2.leftToLeft = 0;
                layoutParams2.rightToRight = 0;
                if (c().b() < 0) {
                    layoutParams2.topToTop = 0;
                } else {
                    layoutParams2.topToBottom = c().b();
                }
                layoutParams2.horizontalBias = 0.0f;
                int i17 = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
                if (i17 > maxWidth || i17 == -1) {
                    ((ViewGroup.MarginLayoutParams) layoutParams2).width = maxWidth;
                }
            }
        }
        c().e(view.getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.rich.part.a
    public boolean a(@NotNull ConstraintLayout container, @NotNull j richData) {
        com.tencent.android.androidbypass.richui.viewdata.j jVar;
        com.tencent.qqnt.rich.d b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) container, (Object) richData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(richData, "richData");
        this.richElementGroupList.clear();
        for (com.tencent.android.androidbypass.viewgroup.b bVar : richData.a().a()) {
            if (bVar instanceof f) {
                this.richElementGroupList.add(bVar);
            }
        }
        Iterator<T> it = this.richElementGroupList.iterator();
        while (it.hasNext()) {
            com.tencent.android.androidbypass.richui.viewdata.k e16 = ((f) it.next()).e();
            if (e16 instanceof com.tencent.android.androidbypass.richui.viewdata.j) {
                jVar = (com.tencent.android.androidbypass.richui.viewdata.j) e16;
            } else {
                jVar = null;
            }
            if (jVar != null && !TextUtils.isEmpty(jVar.F()) && (b16 = d().b()) != null) {
                Context context = container.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "container.context");
                HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> b17 = b16.b(context, jVar.F());
                if (b17 != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("MarkdownPart", 4, "[bind]: use morphisCache, templateId= " + jVar.F());
                    }
                    jVar.d(b17);
                }
            }
        }
        c().e(-1);
        this.cacheManager.e(false);
        com.tencent.android.androidbypass.parser.a j3 = j();
        Context context2 = container.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "container.context");
        ArrayList d16 = a.C0724a.d(j3, context2, container, richData.a().a(), null, new b(richData), 8, null);
        c().c().clear();
        c().c().addAll(d16);
        return false;
    }

    @NotNull
    public final i k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mStyleSheet;
    }

    public final void m(@NotNull TextView textView, int maxWidth, @NotNull p textInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, textView, Integer.valueOf(maxWidth), textInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(textInfo, "textInfo");
        textView.setTextColor(textInfo.g());
        textView.setLinkTextColor(textInfo.e());
        textView.setHighlightColor(textInfo.b());
        textView.setTextSize(textInfo.h(), textInfo.f());
        textView.setTypeface(null);
        textView.setMaxWidth(maxWidth);
        textView.setLineSpacing(textInfo.c(), textInfo.d());
        textView.setId(View.generateViewId());
        textView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        textView.setGravity(16);
        textView.setBreakStrategy(textInfo.a());
        Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        if (c().b() < 0) {
            layoutParams.topToTop = 0;
        } else {
            layoutParams.topToBottom = c().b();
        }
        layoutParams.horizontalBias = 0.0f;
        textView.setLayoutParams(layoutParams);
        c().e(textView.getId());
    }

    @Override // com.tencent.qqnt.rich.part.a, com.tencent.qqnt.rich.a
    public void r0(@NotNull String action, @Nullable Object objects) {
        com.tencent.android.androidbypass.richui.viewdata.j jVar;
        ViewParent viewParent;
        com.tencent.qqnt.rich.d b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) action, objects);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        switch (action.hashCode()) {
            case 467761197:
                if (action.equals("rich_clear_cache")) {
                    this.cacheManager.e(true);
                    return;
                }
                return;
            case 478152881:
                if (action.equals("rich_destory")) {
                    Iterator<T> it = this.richElementGroupList.iterator();
                    while (it.hasNext()) {
                        com.tencent.android.androidbypass.richui.viewdata.k e16 = ((f) it.next()).e();
                        ViewGroup viewGroup = null;
                        if (e16 instanceof com.tencent.android.androidbypass.richui.viewdata.j) {
                            jVar = (com.tencent.android.androidbypass.richui.viewdata.j) e16;
                        } else {
                            jVar = null;
                        }
                        if (jVar != null) {
                            if (!TextUtils.isEmpty(jVar.F())) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.i("MarkdownPart", 4, "[destory]: put morphisCache, templateId= " + jVar.F());
                                }
                                HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> hashMap = new HashMap<>();
                                jVar.e(hashMap);
                                if ((!hashMap.isEmpty()) && (b16 = d().b()) != null) {
                                    b16.a(b(), jVar.F(), hashMap);
                                }
                            }
                            View n3 = jVar.n();
                            if (n3 != null) {
                                viewParent = n3.getParent();
                            } else {
                                viewParent = null;
                            }
                            if (viewParent instanceof ViewGroup) {
                                viewGroup = viewParent;
                            }
                            if (viewGroup != null) {
                                viewGroup.removeView(n3);
                            }
                        }
                    }
                    this.richElementGroupList.clear();
                    c().e(-1);
                    this.cacheManager.e(true);
                    return;
                }
                return;
            case 1018068329:
                if (action.equals("rich_theme_change")) {
                    Iterator<T> it5 = this.richElementGroupList.iterator();
                    while (it5.hasNext()) {
                        com.tencent.android.androidbypass.richui.viewdata.k e17 = ((f) it5.next()).e();
                        if (e17 != null) {
                            e17.u();
                        }
                    }
                    return;
                }
                return;
            case 2035834252:
                if (!action.equals("rich_update") || !(objects instanceof JSONArray)) {
                    return;
                }
                Iterator<com.tencent.android.androidbypass.viewgroup.render.a> it6 = c().c().iterator();
                while (it6.hasNext()) {
                    com.tencent.android.androidbypass.viewgroup.render.a next = it6.next();
                    if (next.a() instanceof com.tencent.android.androidbypass.richui.viewdata.k) {
                        Object a16 = next.a();
                        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.android.androidbypass.richui.viewdata.ViewNode");
                        com.tencent.android.androidbypass.richui.viewdata.k kVar = (com.tencent.android.androidbypass.richui.viewdata.k) a16;
                        JSONArray jSONArray = (JSONArray) objects;
                        int length = jSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            JSONObject childAttr = jSONArray.getJSONObject(i3);
                            String viewId = childAttr.optString("viewId");
                            Intrinsics.checkNotNullExpressionValue(viewId, "viewId");
                            com.tencent.android.androidbypass.richui.viewdata.k g16 = kVar.g(viewId);
                            if (g16 != null) {
                                Intrinsics.checkNotNullExpressionValue(childAttr, "childAttr");
                                g16.C(childAttr);
                            }
                            if (g16 == null) {
                                QLog.e("MarkdownPart", 1, "[updateAttributes]: viewId=" + viewId + " node is null");
                            }
                        }
                    }
                }
                return;
            default:
                return;
        }
    }
}
