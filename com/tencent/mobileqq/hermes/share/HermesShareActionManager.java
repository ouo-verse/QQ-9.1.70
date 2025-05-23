package com.tencent.mobileqq.hermes.share;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b5\u00106J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\n\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0016\u001a\u00020\u0004R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0018R3\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\u001aj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002`\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR'\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00020 j\b\u0012\u0004\u0012\u00020\u0002`!8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R6\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010-j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager;", "", "Lcom/tencent/mobileqq/hermes/share/HermesAbsShareAction;", "shareAction", "", "a", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "firstLine", "secondLine", "f", "", "type", "c", "Lcom/tencent/mobileqq/hermes/share/k;", "shareContext", tl.h.F, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "i", "Landroid/graphics/Bitmap;", "e", "b", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "mLoadingDialog", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "d", "()Ljava/util/HashMap;", "shareActions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "getAllActions", "()Ljava/util/HashSet;", "allActions", "Lcom/tencent/mobileqq/hermes/share/j;", "Lcom/tencent/mobileqq/hermes/share/j;", "getShareActionSheet", "()Lcom/tencent/mobileqq/hermes/share/j;", "g", "(Lcom/tencent/mobileqq/hermes/share/j;)V", "shareActionSheet", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getAllItems", "()Ljava/util/ArrayList;", "setAllItems", "(Ljava/util/ArrayList;)V", "allItems", "<init>", "()V", "ShareLine", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class HermesShareActionManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog mLoadingDialog;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, HermesAbsShareAction> shareActions;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<HermesAbsShareAction> allActions;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j shareActionSheet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<ShareActionSheetBuilder.ActionSheetItem> allItems;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager$ShareLine;", "", "(Ljava/lang/String;I)V", "NONE", "FIRST", "SECOND", "hermes-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class ShareLine {
        private static final /* synthetic */ ShareLine[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ShareLine FIRST;
        public static final ShareLine NONE;
        public static final ShareLine SECOND;

        private static final /* synthetic */ ShareLine[] $values() {
            return new ShareLine[]{NONE, FIRST, SECOND};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25353);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            NONE = new ShareLine("NONE", 0);
            FIRST = new ShareLine("FIRST", 1);
            SECOND = new ShareLine("SECOND", 2);
            $VALUES = $values();
        }

        ShareLine(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ShareLine valueOf(String str) {
            return (ShareLine) Enum.valueOf(ShareLine.class, str);
        }

        public static ShareLine[] values() {
            return (ShareLine[]) $VALUES.clone();
        }
    }

    public HermesShareActionManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.shareActions = new LinkedHashMap();
            this.allActions = new HashSet<>();
        }
    }

    public final void a(@NotNull HermesAbsShareAction shareAction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) shareAction);
            return;
        }
        Intrinsics.checkNotNullParameter(shareAction, "shareAction");
        Iterator<T> it = shareAction.e().iterator();
        while (it.hasNext()) {
            this.shareActions.put(Integer.valueOf(((Number) it.next()).intValue()), shareAction);
        }
        this.allActions.add(shareAction);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Dialog dialog = this.mLoadingDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            if (dialog.isShowing()) {
                try {
                    Dialog dialog2 = this.mLoadingDialog;
                    Intrinsics.checkNotNull(dialog2);
                    dialog2.dismiss();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Nullable
    public final HermesAbsShareAction c(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (HermesAbsShareAction) iPatchRedirector.redirect((short) 11, (Object) this, type);
        }
        return this.shareActions.get(Integer.valueOf(type));
    }

    @NotNull
    public final HashMap<Integer, HermesAbsShareAction> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.shareActions;
    }

    @Nullable
    public final Bitmap e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Bitmap) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        j jVar = this.shareActionSheet;
        if (jVar != null) {
            return jVar.G0();
        }
        return null;
    }

    public final void f(@NotNull List<? extends ShareActionSheetBuilder.ActionSheetItem> firstLine, @NotNull List<? extends ShareActionSheetBuilder.ActionSheetItem> secondLine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) firstLine, (Object) secondLine);
            return;
        }
        Intrinsics.checkNotNullParameter(firstLine, "firstLine");
        Intrinsics.checkNotNullParameter(secondLine, "secondLine");
        j jVar = this.shareActionSheet;
        if (jVar != null) {
            jVar.setActionSheetItems(firstLine, secondLine);
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        arrayList.addAll(firstLine);
        arrayList.addAll(secondLine);
        this.allItems = arrayList;
    }

    public final void g(@Nullable j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jVar);
        } else {
            this.shareActionSheet = jVar;
        }
    }

    public final void h(@NotNull k shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) shareContext);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        j jVar = this.shareActionSheet;
        if (jVar != null) {
            jVar.B0(shareContext);
        }
        j jVar2 = this.shareActionSheet;
        if (jVar2 != null) {
            jVar2.show();
        }
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((HermesAbsShareAction) it.next()).h(shareContext, true);
        }
    }

    public final void i(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.mLoadingDialog == null) {
            this.mLoadingDialog = LoadingUtil.showLoadingDialog(activity, activity.getString(R.string.f158821qn), true);
        }
        Dialog dialog = this.mLoadingDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            if (!dialog.isShowing() && !activity.isFinishing()) {
                Dialog dialog2 = this.mLoadingDialog;
                Intrinsics.checkNotNull(dialog2);
                dialog2.show();
            }
        }
    }
}
