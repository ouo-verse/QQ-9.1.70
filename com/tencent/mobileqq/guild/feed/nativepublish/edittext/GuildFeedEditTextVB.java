package com.tencent.mobileqq.guild.feed.nativepublish.edittext;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ReplacementSpan;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.nativedetail.util.FeedUnclassifiedUtilsKt;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditText;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMviUIState;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.b;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.e;
import com.tencent.mobileqq.guild.feed.widget.u;
import com.tencent.mobileqq.guild.util.bj;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk1.b;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 w2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0007:\u0002xyB\u0017\u0012\u0006\u0010Y\u001a\u00020\u001e\u0012\u0006\u0010]\u001a\u00020Z\u00a2\u0006\u0004\bu\u0010vJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\fH\u0002J+\u0010\u0011\u001a\u00020\n2\u001a\u0010\u0010\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e\"\u0006\u0012\u0002\b\u00030\u000fH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J(\u0010\u0019\u001a\u00020\u0018\"\b\b\u0000\u0010\u0014*\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u001cH\u0002J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002J*\u0010(\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002J\u0018\u0010,\u001a\u00020\n2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\"H\u0002J\u0010\u0010.\u001a\u00020\n2\u0006\u0010\t\u001a\u00020-H\u0002J\u0010\u0010/\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u00100\u001a\u00020\nH\u0002J\b\u00101\u001a\u00020\nH\u0002J\u0010\u00103\u001a\u00020\n2\u0006\u0010\t\u001a\u000202H\u0002J\b\u00104\u001a\u00020\u0018H\u0002J\u0010\u00107\u001a\u00020\n2\u0006\u00106\u001a\u000205H\u0002J\b\u00108\u001a\u00020\nH\u0002J\b\u00109\u001a\u00020\nH\u0002J\b\u0010:\u001a\u00020\nH\u0002J\b\u0010;\u001a\u00020\nH\u0002J\b\u0010<\u001a\u00020\nH\u0002J\u0010\u0010=\u001a\u00020\n2\u0006\u00106\u001a\u000205H\u0002J\b\u0010>\u001a\u00020\nH\u0002J\u0018\u0010A\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u001eH\u0002J\u0010\u0010C\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\u0018H\u0002J\u0010\u0010G\u001a\u00020F2\u0006\u0010E\u001a\u00020DH\u0016J\b\u0010H\u001a\u00020\nH\u0016J\b\u0010J\u001a\u00020IH\u0016J\u0016\u0010O\u001a\u0004\u0018\u00010N2\n\u0010M\u001a\u00060Kj\u0002`LH\u0016J\u0016\u0010Q\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000f0PH\u0016J\u0010\u0010R\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010U\u001a\u00020\n2\u0006\u0010T\u001a\u00020SH\u0016J\b\u0010V\u001a\u00020\nH\u0016R\u0014\u0010Y\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u001d\u0010o\u001a\u0004\u0018\u00010j8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u001d\u0010t\u001a\u0004\u0018\u00010p8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bq\u0010l\u001a\u0004\br\u0010s\u00a8\u0006z"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVB;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVB;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$UpdateHintText;", "state", "", "C1", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$InsertTextAtSelection;", "p1", "", "Ljava/lang/Class;", "spanTypes", "q1", "([Ljava/lang/Class;)V", "", "T", "Landroid/text/Editable;", "editable", "spanType", "", Constants.APK_CERTIFICATE, "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$SetInputFilter;", "x1", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$SetTextChangeWatcher;", "y1", "", "emojiType", "emojiCode", ICustomDataEditor.STRING_PARAM_1, "", "tinyId", "name", "atType", "Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;", "atRoleInfo", "r1", "", "groupCode", "groupName", "u1", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$ReplyTextByHashtag;", "v1", "w1", "z1", "o1", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMviUIState$UpdateLinkSpan;", Constants.BASE_IN_PLUGIN_ID, "i1", "Landroid/content/Context;", "context", "E1", "K1", "M1", "L1", "H1", "I1", "F1", "j1", "text", "selectStart", ICustomDataEditor.NUMBER_PARAM_1, "isCut", "N1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVM;", "k1", "Lcom/tencent/mvi/api/ability/d;", "Lcom/tencent/base/api/ability/VBStateCmd;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "", "getObserverStates", "B1", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "I", "viewId", "Landroid/view/ViewGroup$LayoutParams;", "e", "Landroid/view/ViewGroup$LayoutParams;", "layoutParam", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText;", "f", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText;", "mEditText", "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/b;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/b;", "binding", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b$f;", "i", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/b$f;", "mReuseTextChangeIntent", "Lkm1/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "m1", "()Lkm1/b;", "reportMediator", "Lam1/a;", BdhLogUtil.LogTag.Tag_Conn, "l1", "()Lam1/a;", "inputMethodApi", "<init>", "(ILandroid/view/ViewGroup$LayoutParams;)V", "D", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedEditTextVB extends BaseVB<com.tencent.mobileqq.guild.feed.nativepublish.edittext.b, GuildFeedEditTextMviUIState, com.tencent.base.api.runtime.a<zl1.a>> {

    @NotNull
    private static final Class<?>[] E = {u.class, AtTroopMemberSpan.class, EmoticonSpan.class};

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputMethodApi;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int viewId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup.LayoutParams layoutParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildFeedEditText mEditText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b binding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b.TextChangedIntent mReuseTextChangeIntent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy reportMediator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVB$b;", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVB$d", "Landroid/view/ActionMode$Callback;", "Landroid/view/ActionMode;", "mode", "Landroid/view/Menu;", "menu", "", "onCreateActionMode", "onPrepareActionMode", "", "onDestroyActionMode", "Landroid/view/MenuItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "onActionItemClicked", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements ActionMode.Callback {
        d() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(@NotNull ActionMode mode, @NotNull MenuItem item) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(item, "item");
            if (item.getItemId() == 16908320) {
                if (GuildFeedEditTextVB.this.N1(true)) {
                    mode.finish();
                    return true;
                }
            } else if (item.getItemId() == 16908321) {
                GuildFeedEditTextVB.this.sendIntent(new b.c());
                if (GuildFeedEditTextVB.this.N1(false)) {
                    mode.finish();
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(@NotNull ActionMode mode, @NotNull Menu menu) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(menu, "menu");
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(@NotNull ActionMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(@NotNull ActionMode mode, @NotNull Menu menu) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(menu, "menu");
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class e<T> implements Comparator {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            sk1.b bVar = (sk1.b) ((Triple) t16).component1();
            GuildFeedEditText guildFeedEditText = GuildFeedEditTextVB.this.mEditText;
            GuildFeedEditText guildFeedEditText2 = null;
            if (guildFeedEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText = null;
            }
            Integer valueOf = Integer.valueOf(guildFeedEditText.getEditableText().getSpanStart(bVar));
            sk1.b bVar2 = (sk1.b) ((Triple) t17).component1();
            GuildFeedEditText guildFeedEditText3 = GuildFeedEditTextVB.this.mEditText;
            if (guildFeedEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                guildFeedEditText2 = guildFeedEditText3;
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Integer.valueOf(guildFeedEditText2.getEditableText().getSpanStart(bVar2)));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class f<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Editable f221881d;

        public f(Editable editable) {
            this.f221881d = editable;
        }

        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(this.f221881d.getSpanStart(t17)), Integer.valueOf(this.f221881d.getSpanStart(t16)));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVB$g", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText$a;", "", "a", "b", "onCopy", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class g implements GuildFeedEditText.a {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditText.a
        public boolean a() {
            GuildFeedEditTextVB.this.sendIntent(new b.d());
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditText.a
        public boolean b() {
            return GuildFeedEditTextVB.this.N1(true);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditText.a
        public boolean onCopy() {
            return GuildFeedEditTextVB.this.N1(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class i<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Spannable f221883d;

        public i(Spannable spannable) {
            this.f221883d = spannable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(this.f221883d.getSpanStart((sk1.b) t16)), Integer.valueOf(this.f221883d.getSpanStart((sk1.b) t17)));
            return compareValues;
        }
    }

    public GuildFeedEditTextVB(int i3, @NotNull ViewGroup.LayoutParams layoutParam) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(layoutParam, "layoutParam");
        this.viewId = i3;
        this.layoutParam = layoutParam;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<km1.b>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextVB$reportMediator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final km1.b invoke() {
                View safetyGetHostView = GuildFeedEditTextVB.this.safetyGetHostView();
                if (safetyGetHostView != null) {
                    return (km1.b) n.s(safetyGetHostView, km1.b.class);
                }
                return null;
            }
        });
        this.reportMediator = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<am1.a>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextVB$inputMethodApi$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final am1.a invoke() {
                View safetyGetHostView = GuildFeedEditTextVB.this.safetyGetHostView();
                if (safetyGetHostView != null) {
                    return (am1.a) n.s(safetyGetHostView, am1.a.class);
                }
                return null;
            }
        });
        this.inputMethodApi = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(GuildFeedEditTextVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.i1()) {
            GuildFeedEditText guildFeedEditText = this$0.mEditText;
            GuildFeedEditText guildFeedEditText2 = null;
            if (guildFeedEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText = null;
            }
            guildFeedEditText.requestFocus();
            QLog.d("GuildFeedEditTextVB", 1, "handleShowKeyboard showInput");
            Object systemService = this$0.getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            GuildFeedEditText guildFeedEditText3 = this$0.mEditText;
            if (guildFeedEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                guildFeedEditText2 = guildFeedEditText3;
            }
            inputMethodManager.showSoftInput(guildFeedEditText2, 0);
        }
    }

    private final void C1(GuildFeedEditTextMviUIState.UpdateHintText state) {
        int screenWidth;
        Resources resources;
        DisplayMetrics displayMetrics;
        bl1.b bVar = bl1.b.f28597a;
        GuildFeedEditText guildFeedEditText = this.mEditText;
        GuildFeedEditText guildFeedEditText2 = null;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        String obj = state.getHint().toString();
        GuildFeedEditText guildFeedEditText3 = this.mEditText;
        if (guildFeedEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText3 = null;
        }
        Context context = guildFeedEditText3.getContext();
        if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            screenWidth = displayMetrics.widthPixels;
        } else {
            screenWidth = ViewUtils.getScreenWidth();
        }
        String d16 = bVar.d(guildFeedEditText, obj, 12, screenWidth - ViewUtils.dpToPx(64.0f), "");
        GuildFeedEditText guildFeedEditText4 = this.mEditText;
        if (guildFeedEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            guildFeedEditText2 = guildFeedEditText4;
        }
        guildFeedEditText2.setHint(d16);
    }

    private final void D1(GuildFeedEditTextMviUIState.UpdateLinkSpan state) {
        List sortedWith;
        Object firstOrNull;
        Object lastOrNull;
        com.tencent.mobileqq.guild.feed.nativepublish.edittext.h hVar;
        com.tencent.mobileqq.guild.feed.nativepublish.edittext.h hVar2;
        GuildFeedEditText guildFeedEditText;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(state.a(), new e());
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) sortedWith);
        Triple triple = (Triple) firstOrNull;
        if (triple != null) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) sortedWith);
            Triple triple2 = (Triple) lastOrNull;
            if (triple2 == null) {
                return;
            }
            GuildFeedEditText guildFeedEditText2 = this.mEditText;
            if (guildFeedEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText2 = null;
            }
            int spanStart = guildFeedEditText2.getEditableText().getSpanStart(triple.getFirst());
            GuildFeedEditText guildFeedEditText3 = this.mEditText;
            if (guildFeedEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText3 = null;
            }
            int spanEnd = guildFeedEditText3.getEditableText().getSpanEnd(triple2.getFirst());
            GuildFeedEditText guildFeedEditText4 = this.mEditText;
            if (guildFeedEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText4 = null;
            }
            CharSequence subSequence = guildFeedEditText4.getEditableText().subSequence(spanStart, spanEnd);
            Intrinsics.checkNotNull(subSequence, "null cannot be cast to non-null type android.text.Editable");
            Editable editable = (Editable) subSequence;
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = sortedWith.iterator();
            while (it.hasNext()) {
                Triple triple3 = (Triple) it.next();
                sk1.b bVar = (sk1.b) triple3.component1();
                String str = (String) triple3.component2();
                int intValue = ((Number) triple3.component3()).intValue();
                int spanStart2 = editable.getSpanStart(bVar);
                int spanEnd2 = editable.getSpanEnd(bVar);
                b.Companion companion = sk1.b.INSTANCE;
                Iterator it5 = it;
                String url = bVar.getUrl();
                int i3 = spanStart;
                GuildFeedEditText guildFeedEditText5 = this.mEditText;
                if (guildFeedEditText5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    guildFeedEditText5 = null;
                }
                SpannableString c16 = companion.c(intValue, str, url, guildFeedEditText5);
                if (spanStart2 >= 0 && spanEnd2 >= 0) {
                    editable.removeSpan(bVar);
                    editable.replace(spanStart2, spanEnd2, c16);
                }
                it = it5;
                spanStart = i3;
            }
            int i16 = spanStart;
            QLog.d("GuildFeedEditTextVB", 4, "[handleUpdateLinkSpan] building replacement costs: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            QLog.d("GuildFeedEditTextVB", 1, "[handleUpdateLinkSpan] processed " + state.a().size() + " spans");
            long currentTimeMillis2 = System.currentTimeMillis();
            sendIntent(new b.a(true));
            GuildFeedEditText guildFeedEditText6 = this.mEditText;
            if (guildFeedEditText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText6 = null;
            }
            Editable editableText = guildFeedEditText6.getEditableText();
            if (editableText instanceof com.tencent.mobileqq.guild.feed.nativepublish.edittext.h) {
                hVar = (com.tencent.mobileqq.guild.feed.nativepublish.edittext.h) editableText;
            } else {
                hVar = null;
            }
            if (hVar != null) {
                hVar.a();
            }
            GuildFeedEditText guildFeedEditText7 = this.mEditText;
            if (guildFeedEditText7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText7 = null;
            }
            guildFeedEditText7.getEditableText().removeSpan(triple.getFirst());
            GuildFeedEditText guildFeedEditText8 = this.mEditText;
            if (guildFeedEditText8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText8 = null;
            }
            guildFeedEditText8.getEditableText().removeSpan(triple2.getFirst());
            GuildFeedEditText guildFeedEditText9 = this.mEditText;
            if (guildFeedEditText9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText9 = null;
            }
            guildFeedEditText9.getEditableText().replace(i16, spanEnd, editable);
            GuildFeedEditText guildFeedEditText10 = this.mEditText;
            if (guildFeedEditText10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText10 = null;
            }
            Editable editableText2 = guildFeedEditText10.getEditableText();
            if (editableText2 instanceof com.tencent.mobileqq.guild.feed.nativepublish.edittext.h) {
                hVar2 = (com.tencent.mobileqq.guild.feed.nativepublish.edittext.h) editableText2;
            } else {
                hVar2 = null;
            }
            if (hVar2 != null) {
                hVar2.c();
            }
            sendIntent(new b.a(false));
            QLog.d("GuildFeedEditTextVB", 4, "[handleUpdateLinkSpan] editable.replace costs: " + (System.currentTimeMillis() - currentTimeMillis2) + " ms");
            GuildFeedEditText guildFeedEditText11 = this.mEditText;
            if (guildFeedEditText11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText = null;
            } else {
                guildFeedEditText = guildFeedEditText11;
            }
            guildFeedEditText.requestFocus();
        }
    }

    private final void E1(Context context) {
        F1(context);
        j1();
        I1();
        L1();
        H1();
        K1();
        M1();
    }

    private final void F1(Context context) {
        GuildFeedEditText guildFeedEditText = this.mEditText;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        guildFeedEditText.setHint(context.getResources().getString(R.string.f145070qh));
        QRouteApi api = QRoute.api(IGuildEmojiApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildEmojiApi::class.java)");
        guildFeedEditText.setEditableFactory(new GuildFeedEditableFactory(IGuildEmojiApi.a.a((IGuildEmojiApi) api, 18, 0, 2, null), E, 18));
        guildFeedEditText.setFocusableInTouchMode(true);
    }

    private final <T> boolean G1(Editable editable, Class<T> spanType) {
        boolean z16;
        List sortedWith;
        Object[] spans = editable.getSpans(0, editable.length(), spanType);
        Intrinsics.checkNotNullExpressionValue(spans, "spans");
        if (spans.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            sortedWith = ArraysKt___ArraysKt.sortedWith(spans, new f(editable));
            for (T t16 : sortedWith) {
                int spanStart = editable.getSpanStart(t16);
                int spanEnd = editable.getSpanEnd(t16);
                editable.removeSpan(t16);
                editable.delete(spanStart, spanEnd);
            }
            return true;
        }
        return false;
    }

    private final void H1() {
        GuildFeedEditText guildFeedEditText = this.mEditText;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        guildFeedEditText.setCustomClipboardCopyListener(new g());
    }

    private final void I1() {
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar = this.binding;
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar = null;
        }
        bVar.p();
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar3 = this.binding;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bVar2 = bVar3;
        }
        bVar2.o(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildFeedEditTextVB.J1(GuildFeedEditTextVB.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J1(GuildFeedEditTextVB this$0, View view) {
        HashMap hashMapOf;
        Pair<String, Object> a16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.a(view)) {
            this$0.sendIntent(b.C7765b.f221901d);
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("eid", "em_sgrp_unfold_packup"), TuplesKt.to("sgrp_btn_type", 1));
            km1.b m16 = this$0.m1();
            if (m16 != null && (a16 = m16.a()) != null) {
                hashMapOf.put(a16.component1(), a16.component2());
            }
            VideoReport.reportEvent("clck", hashMapOf);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void K1() {
        GuildFeedEditText guildFeedEditText = this.mEditText;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        guildFeedEditText.setMovementMethod(new h());
    }

    private final void L1() {
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar = this.binding;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar = null;
        }
        bVar.getInput().setOnKeyEventPreImeListener(new Function1<KeyEvent, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextVB$setupOnKeyEventPreImeListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable KeyEvent keyEvent) {
                com.tencent.base.api.runtime.a aVar;
                j e16;
                boolean z16 = false;
                if (keyEvent != null) {
                    GuildFeedEditTextMsgIntent.OnKeyPreIme onKeyPreIme = new GuildFeedEditTextMsgIntent.OnKeyPreIme(keyEvent, false, 2, null);
                    FrameworkVM mUIModel = GuildFeedEditTextVB.this.getMUIModel();
                    if (mUIModel != null && (aVar = (com.tencent.base.api.runtime.a) mUIModel.getMContext()) != null && (e16 = aVar.e()) != null) {
                        e16.h(onKeyPreIme);
                    }
                    z16 = onKeyPreIme.getIsConsumed();
                }
                return Boolean.valueOf(z16);
            }
        });
    }

    private final void M1() {
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar = this.binding;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar = null;
        }
        FeedUnclassifiedUtilsKt.b(bVar.getInput(), ViewConfiguration.getScrollDefaultDelay(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextVB$setupOnScrollDtReport$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar2;
                HashMap hashMapOf;
                km1.b m16;
                Pair<String, Object> a16;
                if (z16) {
                    bVar2 = GuildFeedEditTextVB.this.binding;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        bVar2 = null;
                    }
                    if (bVar2.getInput().getDrawingTime() > 0) {
                        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("eid", "em_sgrp_slide"));
                        m16 = GuildFeedEditTextVB.this.m1();
                        if (m16 != null && (a16 = m16.a()) != null) {
                            hashMapOf.put(a16.component1(), a16.component2());
                        }
                        VideoReport.reportEvent("clck", hashMapOf);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean N1(boolean isCut) {
        boolean z16;
        GuildFeedEditText guildFeedEditText = this.mEditText;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        Editable editableText = guildFeedEditText.getEditableText();
        int selectionStart = Selection.getSelectionStart(editableText);
        int selectionEnd = Selection.getSelectionEnd(editableText);
        int i3 = 0;
        if (selectionStart >= selectionEnd) {
            return false;
        }
        CharSequence subSequence = editableText.subSequence(selectionStart, selectionEnd);
        Intrinsics.checkNotNull(subSequence, "null cannot be cast to non-null type android.text.Spannable");
        Spannable spannable = (Spannable) subSequence;
        sk1.b[] linkSpans = (sk1.b[]) spannable.getSpans(0, spannable.length(), sk1.b.class);
        Intrinsics.checkNotNullExpressionValue(linkSpans, "linkSpans");
        if (linkSpans.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        if (linkSpans.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(linkSpans, new i(spannable));
        }
        StringBuilder sb5 = new StringBuilder();
        int length = linkSpans.length;
        int i16 = 0;
        while (i3 < length) {
            sk1.b bVar = linkSpans[i3];
            int spanStart = spannable.getSpanStart(bVar);
            int spanEnd = spannable.getSpanEnd(bVar);
            if (spanStart - i16 > 0) {
                sb5.append(spannable.subSequence(i16, spanStart).toString());
            }
            sb5.append(bVar.getUrl());
            if (spanEnd < spannable.length() && spannable.charAt(spanEnd) != ' ') {
                sb5.append(" ");
            }
            i3++;
            i16 = spanEnd;
        }
        sb5.append(spannable.subSequence(i16, spannable.length()).toString());
        Object systemService = getMContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("Copied Text", sb5));
        if (isCut) {
            editableText.delete(selectionStart, selectionEnd);
        }
        return true;
    }

    private final boolean i1() {
        if (getMContext() instanceof Activity) {
            Context mContext = getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            if (((Activity) mContext).isFinishing()) {
                return true;
            }
        }
        return false;
    }

    private final void j1() {
        GuildFeedEditText guildFeedEditText = this.mEditText;
        GuildFeedEditText guildFeedEditText2 = null;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        guildFeedEditText.addTextChangedListener(new c());
        GuildFeedEditText guildFeedEditText3 = this.mEditText;
        if (guildFeedEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText3 = null;
        }
        guildFeedEditText3.setCustomSelectionActionModeCallback(new d());
        GuildFeedEditText guildFeedEditText4 = this.mEditText;
        if (guildFeedEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText4 = null;
        }
        GuildFeedEditText guildFeedEditText5 = this.mEditText;
        if (guildFeedEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            guildFeedEditText2 = guildFeedEditText5;
        }
        guildFeedEditText4.setCustomInsertionActionModeCallback(guildFeedEditText2.getCustomSelectionActionModeCallback());
    }

    private final am1.a l1() {
        return (am1.a) this.inputMethodApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final km1.b m1() {
        return (km1.b) this.reportMediator.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.guild.feed.nativepublish.edittext.b n1(Editable text, int selectStart) {
        if (this.mReuseTextChangeIntent == null) {
            this.mReuseTextChangeIntent = new b.TextChangedIntent(text, selectStart);
        }
        b.TextChangedIntent textChangedIntent = this.mReuseTextChangeIntent;
        Intrinsics.checkNotNull(textChangedIntent);
        textChangedIntent.b(text);
        b.TextChangedIntent textChangedIntent2 = this.mReuseTextChangeIntent;
        Intrinsics.checkNotNull(textChangedIntent2);
        textChangedIntent2.c(selectStart);
        b.TextChangedIntent textChangedIntent3 = this.mReuseTextChangeIntent;
        Intrinsics.checkNotNull(textChangedIntent3);
        return textChangedIntent3;
    }

    private final void o1() {
        QLog.d("GuildFeedEditTextVB", 1, "handleHideKeyboard hideSoftInputFromWindow");
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        GuildFeedEditText guildFeedEditText = this.mEditText;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        inputMethodManager.hideSoftInputFromWindow(guildFeedEditText.getWindowToken(), 0);
    }

    private final void p1(GuildFeedEditTextMviUIState.InsertTextAtSelection state) {
        sendIntent(new b.a(state.getBlockDetect()));
        GuildFeedEditText guildFeedEditText = null;
        if (state.getIndex() != null) {
            GuildFeedEditText guildFeedEditText2 = this.mEditText;
            if (guildFeedEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                guildFeedEditText = guildFeedEditText2;
            }
            guildFeedEditText.getEditableText().replace(state.getIndex().intValue(), state.getIndex().intValue(), state.getText());
        } else {
            GuildFeedEditText guildFeedEditText3 = this.mEditText;
            if (guildFeedEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText3 = null;
            }
            int selectionStart = guildFeedEditText3.getSelectionStart();
            GuildFeedEditText guildFeedEditText4 = this.mEditText;
            if (guildFeedEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText4 = null;
            }
            int selectionEnd = guildFeedEditText4.getSelectionEnd();
            GuildFeedEditText guildFeedEditText5 = this.mEditText;
            if (guildFeedEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                guildFeedEditText = guildFeedEditText5;
            }
            guildFeedEditText.getEditableText().replace(Math.max(0, Math.min(selectionStart, selectionEnd)), Math.max(0, Math.max(selectionStart, selectionEnd)), state.getText());
        }
        sendIntent(new b.a(false));
    }

    private final void q1(Class<?>... spanTypes) {
        sendIntent(new b.a(true));
        GuildFeedEditText guildFeedEditText = this.mEditText;
        GuildFeedEditText guildFeedEditText2 = null;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        Editable text = guildFeedEditText.getText();
        if (text == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(text, "mEditText.text ?: return");
        boolean z16 = false;
        for (Class<?> cls : spanTypes) {
            if (G1(text, cls)) {
                z16 = true;
            }
        }
        if (z16) {
            GuildFeedEditText guildFeedEditText3 = this.mEditText;
            if (guildFeedEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText3 = null;
            }
            guildFeedEditText3.setText(text);
            GuildFeedEditText guildFeedEditText4 = this.mEditText;
            if (guildFeedEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                guildFeedEditText2 = guildFeedEditText4;
            }
            guildFeedEditText2.setSelection(text.length());
            n.z(0, R.string.f144860px);
        }
        sendIntent(new b.a(false));
    }

    private final void r1(String tinyId, String name, int atType, AtRoleInfo atRoleInfo) {
        GuildFeedEditText guildFeedEditText;
        GuildFeedEditText guildFeedEditText2 = this.mEditText;
        GuildFeedEditText guildFeedEditText3 = null;
        if (guildFeedEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText2 = null;
        }
        int selectionStart = guildFeedEditText2.getSelectionStart();
        GuildFeedEditText guildFeedEditText4 = this.mEditText;
        if (guildFeedEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText4 = null;
        }
        int selectionEnd = guildFeedEditText4.getSelectionEnd();
        Context mContext = getMContext();
        GuildFeedEditText guildFeedEditText5 = this.mEditText;
        if (guildFeedEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        } else {
            guildFeedEditText = guildFeedEditText5;
        }
        SpannableString q16 = com.tencent.guild.aio.input.at.utils.b.q(mContext, tinyId, name, name, guildFeedEditText, 0, false, true, atType, atRoleInfo);
        if (selectionStart > 0 && selectionStart == selectionEnd) {
            GuildFeedEditText guildFeedEditText6 = this.mEditText;
            if (guildFeedEditText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText6 = null;
            }
            int i3 = selectionStart - 1;
            char charAt = guildFeedEditText6.getEditableText().charAt(i3);
            if (charAt == '@' || charAt == '\uff20') {
                GuildFeedEditText guildFeedEditText7 = this.mEditText;
                if (guildFeedEditText7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    guildFeedEditText7 = null;
                }
                if (!so0.e.b(guildFeedEditText7.getEditableText(), i3, 0, selectionStart, ReplacementSpan.class)) {
                    selectionStart--;
                }
            }
        }
        GuildFeedEditText guildFeedEditText8 = this.mEditText;
        if (guildFeedEditText8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText8 = null;
        }
        guildFeedEditText8.getEditableText().replace(selectionStart, selectionEnd, q16);
        GuildFeedEditText guildFeedEditText9 = this.mEditText;
        if (guildFeedEditText9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            guildFeedEditText3 = guildFeedEditText9;
        }
        guildFeedEditText3.requestFocus();
        z1();
    }

    private final void s1(int emojiType, int emojiCode) {
        String emojiString;
        GuildFeedEditText guildFeedEditText = this.mEditText;
        GuildFeedEditText guildFeedEditText2 = null;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        int selectionStart = guildFeedEditText.getSelectionStart();
        GuildFeedEditText guildFeedEditText3 = this.mEditText;
        if (guildFeedEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText3 = null;
        }
        int selectionEnd = guildFeedEditText3.getSelectionEnd();
        if (emojiType == 1) {
            emojiString = TextUtils.getSysEmotcationString(emojiCode);
        } else {
            emojiString = TextUtils.getEmojiString(emojiCode);
        }
        GuildFeedEditText guildFeedEditText4 = this.mEditText;
        if (guildFeedEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText4 = null;
        }
        guildFeedEditText4.getEditableText().replace(selectionStart, selectionEnd, emojiString);
        GuildFeedEditText guildFeedEditText5 = this.mEditText;
        if (guildFeedEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            guildFeedEditText2 = guildFeedEditText5;
        }
        guildFeedEditText2.requestFocus();
    }

    private final void u1(long groupCode, String groupName) {
        GuildFeedEditText guildFeedEditText = this.mEditText;
        GuildFeedEditText guildFeedEditText2 = null;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        int selectionStart = guildFeedEditText.getSelectionStart();
        GuildFeedEditText guildFeedEditText3 = this.mEditText;
        if (guildFeedEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText3 = null;
        }
        int selectionEnd = guildFeedEditText3.getSelectionEnd();
        QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
        qQProAvatarDrawable.q(getMContext(), 4, String.valueOf(groupCode));
        Context mContext = getMContext();
        String valueOf = String.valueOf(groupCode);
        GuildFeedEditText guildFeedEditText4 = this.mEditText;
        if (guildFeedEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText4 = null;
        }
        SpannableString t16 = com.tencent.guild.aio.input.at.utils.e.t(mContext, valueOf, groupName, guildFeedEditText4, qQProAvatarDrawable);
        if (selectionStart > 0 && selectionStart == selectionEnd) {
            GuildFeedEditText guildFeedEditText5 = this.mEditText;
            if (guildFeedEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText5 = null;
            }
            int i3 = selectionStart - 1;
            char charAt = guildFeedEditText5.getEditableText().charAt(i3);
            if (charAt == '*' || charAt == '\uff0a') {
                GuildFeedEditText guildFeedEditText6 = this.mEditText;
                if (guildFeedEditText6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    guildFeedEditText6 = null;
                }
                if (!so0.e.b(guildFeedEditText6.getEditableText(), i3, 0, selectionStart, ReplacementSpan.class)) {
                    selectionStart--;
                }
            }
        }
        GuildFeedEditText guildFeedEditText7 = this.mEditText;
        if (guildFeedEditText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText7 = null;
        }
        guildFeedEditText7.getEditableText().replace(selectionStart, selectionEnd, t16);
        GuildFeedEditText guildFeedEditText8 = this.mEditText;
        if (guildFeedEditText8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            guildFeedEditText2 = guildFeedEditText8;
        }
        guildFeedEditText2.requestFocus();
        z1();
    }

    private final void v1(GuildFeedEditTextMviUIState.ReplyTextByHashtag state) {
        GuildFeedEditText guildFeedEditText = this.mEditText;
        GuildFeedEditText guildFeedEditText2 = null;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        int selectionStart = guildFeedEditText.getSelectionStart();
        GuildFeedEditText guildFeedEditText3 = this.mEditText;
        if (guildFeedEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText3 = null;
        }
        int selectionEnd = guildFeedEditText3.getSelectionEnd();
        Context mContext = getMContext();
        String channelId = state.getChannelId();
        String a16 = bj.a(state.getChannelName(), state.getType());
        int channelType = state.getChannelType();
        GuildFeedEditText guildFeedEditText4 = this.mEditText;
        if (guildFeedEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText4 = null;
        }
        SpannableString w3 = com.tencent.guild.aio.input.at.utils.d.w(mContext, channelId, a16, channelType, guildFeedEditText4, 0, false, true, state.getType().getValue(), null);
        if (selectionStart > 0 && selectionStart == selectionEnd) {
            GuildFeedEditText guildFeedEditText5 = this.mEditText;
            if (guildFeedEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText5 = null;
            }
            int i3 = selectionStart - 1;
            char charAt = guildFeedEditText5.getEditableText().charAt(i3);
            if (charAt == '*' || charAt == '\uff0a') {
                GuildFeedEditText guildFeedEditText6 = this.mEditText;
                if (guildFeedEditText6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    guildFeedEditText6 = null;
                }
                if (!so0.e.b(guildFeedEditText6.getEditableText(), i3, 0, selectionStart, ReplacementSpan.class)) {
                    selectionStart--;
                }
            }
        }
        GuildFeedEditText guildFeedEditText7 = this.mEditText;
        if (guildFeedEditText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText7 = null;
        }
        guildFeedEditText7.getEditableText().replace(selectionStart, selectionEnd, w3);
        GuildFeedEditText guildFeedEditText8 = this.mEditText;
        if (guildFeedEditText8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            guildFeedEditText2 = guildFeedEditText8;
        }
        guildFeedEditText2.requestFocus();
        z1();
    }

    private final void w1(Editable editable) {
        sendIntent(new b.a(true));
        GuildFeedEditText guildFeedEditText = this.mEditText;
        GuildFeedEditText guildFeedEditText2 = null;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        guildFeedEditText.setText(editable);
        GuildFeedEditText guildFeedEditText3 = this.mEditText;
        if (guildFeedEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText3 = null;
        }
        GuildFeedEditText guildFeedEditText4 = this.mEditText;
        if (guildFeedEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            guildFeedEditText2 = guildFeedEditText4;
        }
        Editable text = guildFeedEditText2.getText();
        Intrinsics.checkNotNull(text);
        guildFeedEditText3.setSelection(text.length());
        sendIntent(new b.a(false));
    }

    private final void x1(GuildFeedEditTextMviUIState.SetInputFilter state) {
        Object[] plus;
        GuildFeedEditText guildFeedEditText = this.mEditText;
        GuildFeedEditText guildFeedEditText2 = null;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        InputFilter[] originFilter = guildFeedEditText.getFilters();
        if (state.getIsAdd()) {
            GuildFeedEditText guildFeedEditText3 = this.mEditText;
            if (guildFeedEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                guildFeedEditText2 = guildFeedEditText3;
            }
            Intrinsics.checkNotNullExpressionValue(originFilter, "originFilter");
            plus = ArraysKt___ArraysJvmKt.plus(originFilter, state.getFilter());
            guildFeedEditText2.setFilters((InputFilter[]) plus);
            return;
        }
        GuildFeedEditText guildFeedEditText4 = this.mEditText;
        if (guildFeedEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            guildFeedEditText2 = guildFeedEditText4;
        }
        Intrinsics.checkNotNullExpressionValue(originFilter, "originFilter");
        ArrayList arrayList = new ArrayList();
        for (InputFilter inputFilter : originFilter) {
            if (!Intrinsics.areEqual(inputFilter, state.getFilter())) {
                arrayList.add(inputFilter);
            }
        }
        Object[] array = arrayList.toArray(new InputFilter[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        guildFeedEditText2.setFilters((InputFilter[]) array);
    }

    private final void y1(GuildFeedEditTextMviUIState.SetTextChangeWatcher state) {
        GuildFeedEditText guildFeedEditText = null;
        if (state.getIsAdd()) {
            GuildFeedEditText guildFeedEditText2 = this.mEditText;
            if (guildFeedEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            } else {
                guildFeedEditText = guildFeedEditText2;
            }
            guildFeedEditText.addTextChangedListener(state.getWatcher());
            return;
        }
        GuildFeedEditText guildFeedEditText3 = this.mEditText;
        if (guildFeedEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            guildFeedEditText = guildFeedEditText3;
        }
        guildFeedEditText.removeTextChangedListener(state.getWatcher());
    }

    private final void z1() {
        am1.a l16 = l1();
        if (l16 != null) {
            l16.b(200L);
            return;
        }
        if (!i1()) {
            GuildFeedEditText guildFeedEditText = this.mEditText;
            if (guildFeedEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText = null;
            }
            guildFeedEditText.requestFocus();
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedEditTextVB.A1(GuildFeedEditTextVB.this);
                }
            }, 200L);
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildFeedEditTextMviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildFeedEditTextMviUIState.ReplyTextByEmoji) {
            GuildFeedEditTextMviUIState.ReplyTextByEmoji replyTextByEmoji = (GuildFeedEditTextMviUIState.ReplyTextByEmoji) state;
            s1(replyTextByEmoji.getEmojiType(), replyTextByEmoji.getEmojiCode());
            return;
        }
        if (state instanceof GuildFeedEditTextMviUIState.ReplyTextByAt) {
            GuildFeedEditTextMviUIState.ReplyTextByAt replyTextByAt = (GuildFeedEditTextMviUIState.ReplyTextByAt) state;
            r1(replyTextByAt.getTinyId(), replyTextByAt.getName(), replyTextByAt.getAtType(), replyTextByAt.getAtRoleInfo());
            return;
        }
        if (state instanceof GuildFeedEditTextMviUIState.ReplyTextByHashtag) {
            v1((GuildFeedEditTextMviUIState.ReplyTextByHashtag) state);
            return;
        }
        if (state instanceof GuildFeedEditTextMviUIState.ReplyTextByGroupTag) {
            GuildFeedEditTextMviUIState.ReplyTextByGroupTag replyTextByGroupTag = (GuildFeedEditTextMviUIState.ReplyTextByGroupTag) state;
            u1(replyTextByGroupTag.getGroupCode(), replyTextByGroupTag.getGroupName());
            return;
        }
        if (state instanceof GuildFeedEditTextMviUIState.SetEditText) {
            w1(((GuildFeedEditTextMviUIState.SetEditText) state).getEditable());
            return;
        }
        if (state instanceof GuildFeedEditTextMviUIState.ShowKeyboard) {
            z1();
            return;
        }
        if (state instanceof GuildFeedEditTextMviUIState.HideKeyboard) {
            o1();
            return;
        }
        if (state instanceof GuildFeedEditTextMviUIState.SetTextChangeWatcher) {
            y1((GuildFeedEditTextMviUIState.SetTextChangeWatcher) state);
            return;
        }
        if (state instanceof GuildFeedEditTextMviUIState.SetInputFilter) {
            x1((GuildFeedEditTextMviUIState.SetInputFilter) state);
            return;
        }
        if (state instanceof GuildFeedEditTextMviUIState.RemoveSpecialSpans) {
            q1(com.tencent.guild.aio.input.at.utils.b.class, com.tencent.guild.aio.input.at.utils.d.class, sk1.b.class);
            return;
        }
        if (state instanceof GuildFeedEditTextMviUIState.InsertTextAtSelection) {
            p1((GuildFeedEditTextMviUIState.InsertTextAtSelection) state);
        } else if (state instanceof GuildFeedEditTextMviUIState.UpdateLinkSpan) {
            D1((GuildFeedEditTextMviUIState.UpdateLinkSpan) state);
        } else if (state instanceof GuildFeedEditTextMviUIState.UpdateHintText) {
            C1((GuildFeedEditTextMviUIState.UpdateHintText) state);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        am1.a l16 = l1();
        if (l16 != null) {
            com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar = this.binding;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar = null;
            }
            l16.a(bVar.getInput());
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof e.a) {
            e.a aVar = (e.a) stateCmd;
            GuildFeedEditText guildFeedEditText = this.mEditText;
            if (guildFeedEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                guildFeedEditText = null;
            }
            aVar.b(guildFeedEditText.getEditableText());
        }
        return Bundle.EMPTY;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildFeedEditTextMviUIState>> getObserverStates() {
        List<Class<? extends GuildFeedEditTextMviUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildFeedEditTextMviUIState.ReplyTextByEmoji.class, GuildFeedEditTextMviUIState.SetTextChangeWatcher.class, GuildFeedEditTextMviUIState.SetInputFilter.class, GuildFeedEditTextMviUIState.InsertTextAtSelection.class, GuildFeedEditTextMviUIState.RemoveSpecialSpans.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public GuildFeedEditTextVM createVM() {
        return new GuildFeedEditTextVM(null);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar = new com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b(createViewParams.a());
        this.binding = bVar;
        this.mEditText = bVar.getInput();
        E1(createViewParams.a());
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar2 = this.binding;
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar3 = null;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar2 = null;
        }
        View mContainer = bVar2.getMContainer();
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar4 = this.binding;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar4 = null;
        }
        Class<?> cls = bVar4.getClass();
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar5 = this.binding;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar5 = null;
        }
        n.y(mContainer, cls, bVar5);
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar6 = this.binding;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bVar3 = bVar6;
        }
        View mContainer2 = bVar3.getMContainer();
        mContainer2.setId(this.viewId);
        mContainer2.setLayoutParams(this.layoutParam);
        return mContainer2;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        GuildFeedEditText guildFeedEditText = this.mEditText;
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar = null;
        if (guildFeedEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            guildFeedEditText = null;
        }
        guildFeedEditText.setFilters(new InputFilter[0]);
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar2 = this.binding;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bVar = bVar2;
        }
        n.D(bVar.getMContainer(), com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b.class);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        this.mReuseTextChangeIntent = null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVB$h", "Landroid/text/method/ScrollingMovementMethod;", "", "canSelectArbitrarily", "Landroid/widget/TextView;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "Landroid/text/Spannable;", "text", "", QzoneZipCacheHelper.DIR, "", "onTakeFocus", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class h extends ScrollingMovementMethod {
        h() {
        }

        @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean canSelectArbitrarily() {
            return true;
        }

        @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public void onTakeFocus(@Nullable TextView widget, @Nullable Spannable text, int dir) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextVB$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            if (s16 != null) {
                GuildFeedEditTextVB guildFeedEditTextVB = GuildFeedEditTextVB.this;
                GuildFeedEditText guildFeedEditText = guildFeedEditTextVB.mEditText;
                if (guildFeedEditText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                    guildFeedEditText = null;
                }
                guildFeedEditTextVB.sendIntent(guildFeedEditTextVB.n1(s16, guildFeedEditText.getSelectionStart()));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
