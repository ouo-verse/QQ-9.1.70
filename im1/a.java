package im1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorGlobalController;
import com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.SimplifiedFeedEditorViewBinding;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.InputMethodUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yl1.i;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\f\u0018\u00002.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0007B\u000f\u0012\u0006\u0010!\u001a\u00020\u001e\u00a2\u0006\u0004\b7\u00108J\b\u0010\t\u001a\u00020\bH\u0002J\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J$\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u001cH\u0016R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lim1/a;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVB;", "", "h1", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;", "fallbackStateUpdater", "im1/a$b", "i1", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;)Lim1/a$b;", "", "panelId", "targetHeight", ICustomDataEditor.NUMBER_PARAM_1, "Landroid/view/View;", "k1", "j1", "m1", "l1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "bindViewAndData", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "Landroid/view/ViewGroup$LayoutParams;", "d", "Landroid/view/ViewGroup$LayoutParams;", "layoutParam", "", "e", "Ljava/lang/String;", "logTag", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController;", "f", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController;", "globalController", h.F, "I", "Landroid/util/SparseArray;", "i", "Landroid/util/SparseArray;", "mPanelViewList", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "panelLayout", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mPanelView", "<init>", "(Landroid/view/ViewGroup$LayoutParams;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends BaseVB<ol3.b, MviUIState, com.tencent.base.api.runtime.a<zl1.a>> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View mPanelView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup.LayoutParams layoutParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SimplifiedFeedEditorGlobalController globalController;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int panelId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<View> mPanelViewList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private FrameLayout panelLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"im1/a$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/d;", "", "panelId", "targetHeight", "", "e", "f", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.d {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f407992b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(e.b bVar, a aVar) {
            super(bVar);
            this.f407992b = aVar;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void b() {
            this.f407992b.m1();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void e(int panelId, int targetHeight) {
            this.f407992b.n1(panelId, targetHeight);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void f() {
            this.f407992b.l1();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"im1/a$c", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements EmoticonCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f407993d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f407994e;

        c(EditText editText, a aVar) {
            this.f407993d = editText;
            this.f407994e = aVar;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            EditText editText = this.f407993d;
            if (editText != null) {
                TextUtils.backspace(editText);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo info) {
            return false;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(@Nullable EmoticonInfo info) {
            com.tencent.base.api.runtime.a aVar;
            j e16;
            if (info instanceof SystemAndEmojiEmoticonInfo) {
                FrameworkVM mUIModel = this.f407994e.getMUIModel();
                if (mUIModel != null && (aVar = (com.tencent.base.api.runtime.a) mUIModel.getMContext()) != null && (e16 = aVar.e()) != null) {
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) info;
                    e16.h(new GuildFeedEditTextMsgIntent.ReplyTextByEmoji(systemAndEmojiEmoticonInfo.emotionType, systemAndEmojiEmoticonInfo.code));
                }
                ho1.d.a((View) this.f407994e.mPanelViewList.get(1), (SystemAndEmojiEmoticonInfo) info);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(@Nullable EmoticonInfo info) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000K\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u00012\u00020\u0007J\b\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"im1/a$d", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/input/base/mvicompat/ex/a;", "Lcom/tencent/mvi/base/route/k;", "j", "context", "", "l", "", "", "J2", "f0", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", "I", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "d", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "messageRegistry", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends BaseVM<ol3.b, MviUIState, com.tencent.base.api.runtime.a<zl1.a>> implements com.tencent.input.base.mvicompat.ex.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final VMMessengerProtocolSupport messageRegistry = new VMMessengerProtocolSupport(this);

        d() {
        }

        private final k j() {
            boolean z16;
            boolean z17;
            boolean z18 = false;
            if (a.this.globalController != null) {
                SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = a.this.globalController;
                Intrinsics.checkNotNull(simplifiedFeedEditorGlobalController);
                int state = simplifiedFeedEditorGlobalController.v().getState();
                i iVar = i.f450608a;
                if (!iVar.g(state, 1) && !iVar.g(state, 3)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (iVar.g(state, 8) && z16) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (iVar.g(state, 16) && z16) {
                    z18 = true;
                }
                return new h.a(z17, z18, Integer.valueOf(a.this.panelId));
            }
            return new h.a(false, false, Integer.valueOf(a.this.panelId));
        }

        @Override // com.tencent.input.base.mvicompat.ex.a
        public void E(@NotNull MsgIntent event) {
            SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController;
            e v3;
            Intrinsics.checkNotNullParameter(event, "event");
            if ((event instanceof PanelContainerMsgIntent.ShowPanelMsgIntent) && (simplifiedFeedEditorGlobalController = a.this.globalController) != null && (v3 = simplifiedFeedEditorGlobalController.v()) != null) {
                v3.e(((PanelContainerMsgIntent.ShowPanelMsgIntent) event).c());
            }
        }

        @Override // com.tencent.input.base.mvicompat.ex.a
        @NotNull
        public k I(@NotNull MsgIntent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event instanceof PanelContainerMsgIntent.GetPanelContainerStateMsgIntent) {
                return j();
            }
            return new com.tencent.input.base.utils.a();
        }

        @Override // com.tencent.input.base.mvicompat.ex.a
        @NotNull
        public List<String> J2() {
            List<String> listOf;
            String b16 = com.tencent.mvi.base.route.c.b(PanelContainerMsgIntent.ShowPanelMsgIntent.class);
            Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
            listOf = CollectionsKt__CollectionsJVMKt.listOf(b16);
            return listOf;
        }

        @Override // com.tencent.input.base.mvicompat.ex.a
        @NotNull
        public List<String> f0() {
            List<String> listOf;
            String b16 = com.tencent.mvi.base.route.c.b(PanelContainerMsgIntent.GetPanelContainerStateMsgIntent.class);
            Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
            listOf = CollectionsKt__CollectionsJVMKt.listOf(b16);
            return listOf;
        }

        @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onCreate(@NotNull com.tencent.base.api.runtime.a<zl1.a> context) {
            Intrinsics.checkNotNullParameter(context, "context");
            super.onCreate((d) context);
            VMMessengerProtocolSupport vMMessengerProtocolSupport = this.messageRegistry;
            j e16 = context.e();
            Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
            vMMessengerProtocolSupport.d(e16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
        public void onDestroy() {
            super.onDestroy();
            VMMessengerProtocolSupport vMMessengerProtocolSupport = this.messageRegistry;
            j e16 = ((com.tencent.base.api.runtime.a) getMContext()).e();
            Intrinsics.checkNotNullExpressionValue(e16, "mContext.messenger");
            vMMessengerProtocolSupport.e(e16);
        }
    }

    public a(@NotNull ViewGroup.LayoutParams layoutParam) {
        Intrinsics.checkNotNullParameter(layoutParam, "layoutParam");
        this.layoutParam = layoutParam;
        this.logTag = "FeedEditor.PanelContainerVB";
        this.panelId = -1;
        this.mPanelViewList = new SparseArray<>(1);
    }

    private final void h1() {
        e.b bVar;
        e v3;
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = (SimplifiedFeedEditorGlobalController) n.s(getHostView(), SimplifiedFeedEditorGlobalController.class);
        this.globalController = simplifiedFeedEditorGlobalController;
        if (simplifiedFeedEditorGlobalController == null) {
            QLog.w(this.logTag, 1, "[bindViewAndData]: inputAnimController isn't found, functionality may be affected");
            return;
        }
        Intrinsics.checkNotNull(simplifiedFeedEditorGlobalController);
        e v16 = simplifiedFeedEditorGlobalController.v();
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController2 = this.globalController;
        if (simplifiedFeedEditorGlobalController2 != null && (v3 = simplifiedFeedEditorGlobalController2.v()) != null) {
            bVar = v3.getUiStateUpdater();
        } else {
            bVar = null;
        }
        v16.i(i1(bVar));
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController3 = this.globalController;
        Intrinsics.checkNotNull(simplifiedFeedEditorGlobalController3);
        simplifiedFeedEditorGlobalController3.P(new C10541a());
    }

    private final b i1(e.b fallbackStateUpdater) {
        return new b(fallbackStateUpdater, this);
    }

    private final View j1() {
        EditText editText;
        com.tencent.base.api.runtime.a aVar;
        Fragment c16;
        FragmentActivity activity;
        FrameworkVM mUIModel = getMUIModel();
        ColorStateList colorStateList = null;
        if (mUIModel != null && (aVar = (com.tencent.base.api.runtime.a) mUIModel.getMContext()) != null && (c16 = aVar.c()) != null && (activity = c16.getActivity()) != null) {
            editText = (EditText) activity.findViewById(SimplifiedFeedEditorViewBinding.INSTANCE.f());
        } else {
            editText = null;
        }
        View c17 = ho1.d.c(getMContext(), editText, new c(editText, this));
        GradientDrawable gradientDrawable = new GradientDrawable();
        Context mContext = getMContext();
        if (mContext != null) {
            colorStateList = mContext.getColorStateList(R.color.qui_common_bg_bottom_light);
        }
        gradientDrawable.setColor(colorStateList);
        gradientDrawable.setShape(0);
        float o16 = SimplifiedFeedEditorViewBinding.INSTANCE.o();
        gradientDrawable.setCornerRadii(new float[]{o16, o16, o16, o16, 0.0f, 0.0f, 0.0f, 0.0f});
        c17.setBackground(gradientDrawable);
        return c17;
    }

    private final View k1(int panelId) {
        View view;
        if (panelId == 1) {
            view = j1();
        } else {
            view = null;
        }
        if (view != null) {
            this.mPanelViewList.append(panelId, view);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        this.panelId = -1;
        View view = this.mPanelView;
        if (view != null) {
            view.setVisibility(8);
        }
        FrameLayout frameLayout = this.panelLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelLayout");
            frameLayout = null;
        }
        frameLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1() {
        View safetyGetHostView = safetyGetHostView();
        if (safetyGetHostView != null) {
            InputMethodUtil.hide(safetyGetHostView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1(int panelId, int targetHeight) {
        this.panelId = panelId;
        View view = this.mPanelViewList.get(panelId);
        if (view == null) {
            view = k1(panelId);
        }
        if (view != null) {
            FrameLayout frameLayout = null;
            if (!Intrinsics.areEqual(this.mPanelView, view)) {
                if (this.mPanelView != null) {
                    FrameLayout frameLayout2 = this.panelLayout;
                    if (frameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("panelLayout");
                        frameLayout2 = null;
                    }
                    frameLayout2.removeView(this.mPanelView);
                }
                this.mPanelView = view;
                FrameLayout frameLayout3 = this.panelLayout;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelLayout");
                    frameLayout3 = null;
                }
                frameLayout3.addView(view, new FrameLayout.LayoutParams(-1, targetHeight));
            } else {
                view.setVisibility(0);
            }
            FrameLayout frameLayout4 = this.panelLayout;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelLayout");
            } else {
                frameLayout = frameLayout4;
            }
            frameLayout.requestLayout();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        h1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<ol3.b, MviUIState, com.tencent.base.api.runtime.a<zl1.a>> createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        frameLayout.setId(SimplifiedFeedEditorViewBinding.INSTANCE.h());
        frameLayout.setLayoutParams(this.layoutParam);
        this.panelLayout = frameLayout;
        return frameLayout;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"im1/a$a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;", "", "isShowPanel", "", "a", "", "foldState", "keyboardHeight", "c", "state", "onStateChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: im1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C10541a implements e.a {
        C10541a() {
        }

        private final void a(boolean isShowPanel) {
            com.tencent.base.api.runtime.a aVar;
            j e16;
            FrameworkVM mUIModel = a.this.getMUIModel();
            if (mUIModel != null && (aVar = (com.tencent.base.api.runtime.a) mUIModel.getMContext()) != null && (e16 = aVar.e()) != null) {
                e16.h(new PanelContainerMsgIntent.OnPanelStateChangedMsgIntent(isShowPanel, a.this.panelId));
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.a
        public void d() {
            e.a.C7749a.a(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.a
        public void onStateChanged(int state) {
            int i3 = state & 7;
            boolean z16 = false;
            if (i3 != 0) {
                if (i3 == 1) {
                    if ((state & 16) != 0) {
                        z16 = true;
                    }
                    a(z16);
                    return;
                }
                return;
            }
            a(false);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.a
        public void c(int foldState, int keyboardHeight) {
        }
    }
}
