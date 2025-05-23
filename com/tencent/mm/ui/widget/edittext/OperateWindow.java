package com.tencent.mm.ui.widget.edittext;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.luggage.wxa.lo.r;
import com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper;
import com.tencent.mm.ui.widget.textview.TextLayoutUtil;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 F2\u00020\u0001:\u0001FB\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\bD\u0010EJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J \u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\"\u0010\r\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010 R\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010 R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0011\u0010B\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\bB\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/OperateWindow;", "", "", "show", "dismiss", "", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$MenuItem;", "c", "Landroid/view/View;", "v", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "curSelect", "a", "", "str", "", "start", "end", "", "d", "Landroid/content/Context;", "context", "text", "duration", "b", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper;", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper;", "selectableEditTextHelper", "Landroid/widget/PopupWindow;", "Landroid/widget/PopupWindow;", "mWindow", "I", "mWidth", "mHeight", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRecyclerView", "Lcom/tencent/mm/ui/widget/edittext/MyRecycleViewAdapter;", "f", "Lcom/tencent/mm/ui/widget/edittext/MyRecycleViewAdapter;", "getMAdapter", "()Lcom/tencent/mm/ui/widget/edittext/MyRecycleViewAdapter;", "setMAdapter", "(Lcom/tencent/mm/ui/widget/edittext/MyRecycleViewAdapter;)V", "mAdapter", "g", "Ljava/util/List;", "getMMenuItems", "()Ljava/util/List;", "setMMenuItems", "(Ljava/util/List;)V", "mMenuItems", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "getMArrow", "()Landroid/widget/ImageView;", "setMArrow", "(Landroid/widget/ImageView;)V", "mArrow", "isShowing", "()Z", "<init>", "(Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper;Landroid/content/Context;)V", "Companion", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class OperateWindow {

    @NotNull
    public static final String TAG = "EditHelper.OperateWindow";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SelectableEditTextHelper selectableEditTextHelper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final PopupWindow mWindow;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int mWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int mHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public RecyclerView mRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public MyRecycleViewAdapter mAdapter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public List mMenuItems;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public ImageView mArrow;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    public static final int f153239i = 10;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/OperateWindow$Companion;", "", "()V", "MARGIN_LEFT_RIGHT_DP", "", "TAG", "", ViewStickEventHelper.IS_SHOW, "", "handle", "Lcom/tencent/mm/ui/widget/edittext/OperateWindow;", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isShow(@Nullable OperateWindow handle) {
            if (handle == null) {
                return false;
            }
            return handle.isShowing();
        }
    }

    public OperateWindow(@NotNull SelectableEditTextHelper selectableEditTextHelper, @Nullable Context context) {
        Intrinsics.checkNotNullParameter(selectableEditTextHelper, "selectableEditTextHelper");
        this.selectableEditTextHelper = selectableEditTextHelper;
        View inflate = LayoutInflater.from(context).inflate(R.layout.feo, (ViewGroup) null);
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mWidth = inflate.getMeasuredWidth();
        this.mHeight = inflate.getMeasuredHeight();
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, false);
        this.mWindow = popupWindow;
        popupWindow.setClippingEnabled(false);
        View findViewById = inflate.findViewById(R.id.f790548q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.rv_list)");
        this.mRecyclerView = (RecyclerView) findViewById;
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(selectableEditTextHelper.getMContext(), 0, false));
        List c16 = c();
        this.mMenuItems = c16;
        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(c16, new SelectableEditTextHelper.OnMenuCallback() { // from class: com.tencent.mm.ui.widget.edittext.OperateWindow.1
            @Override // com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.OnMenuCallback
            public void onMenuInit(@NotNull List<SelectableEditTextHelper.MenuItem> items, int visibleFlag) {
                Intrinsics.checkNotNullParameter(items, "items");
            }

            @Override // com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.OnMenuCallback
            public void onMenuItemClicked(@NotNull View v3, @NotNull SelectableEditTextHelper.MenuItem item, @NotNull String curSelect) {
                Intrinsics.checkNotNullParameter(v3, "v");
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(curSelect, "curSelect");
                OperateWindow.this.a(v3, item, curSelect);
            }
        }, selectableEditTextHelper.getMSelectionInfo());
        this.mAdapter = myRecycleViewAdapter;
        this.mRecyclerView.setAdapter(myRecycleViewAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(selectableEditTextHelper.getMContext(), 0);
        dividerItemDecoration.setDrawable(new ColorDrawable(selectableEditTextHelper.getMContext().getResources().getColor(R.color.bvt)));
        this.mRecyclerView.addItemDecoration(dividerItemDecoration);
        View findViewById2 = inflate.findViewById(R.id.uck);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.cursor_iv)");
        this.mArrow = (ImageView) findViewById2;
    }

    @JvmStatic
    public static final boolean isShow(@Nullable OperateWindow operateWindow) {
        return INSTANCE.isShow(operateWindow);
    }

    public final void a(View v3, SelectableEditTextHelper.MenuItem item, String curSelect) {
        int i3;
        int i16;
        int i17 = item.id;
        if (i17 != 1) {
            switch (i17) {
                case 16908319:
                    this.selectableEditTextHelper.hideSelectView();
                    SelectableEditTextHelper selectableEditTextHelper = this.selectableEditTextHelper;
                    selectableEditTextHelper.selectText(0, selectableEditTextHelper.getMTextView().getText().length());
                    this.selectableEditTextHelper.setHide(false);
                    this.selectableEditTextHelper.getMTextView().post(new Runnable() { // from class: com.tencent.mm.ui.widget.edittext.OperateWindow$handleMenuItemClick$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            SelectableEditTextHelper selectableEditTextHelper2;
                            SelectableEditTextHelper selectableEditTextHelper3;
                            SelectableEditTextHelper selectableEditTextHelper4;
                            SelectableEditTextHelper selectableEditTextHelper5;
                            SelectableEditTextHelper selectableEditTextHelper6;
                            SelectableEditTextHelper selectableEditTextHelper7;
                            selectableEditTextHelper2 = OperateWindow.this.selectableEditTextHelper;
                            selectableEditTextHelper3 = OperateWindow.this.selectableEditTextHelper;
                            selectableEditTextHelper2.showCursorHandle(selectableEditTextHelper3.getMStartHandle());
                            selectableEditTextHelper4 = OperateWindow.this.selectableEditTextHelper;
                            selectableEditTextHelper5 = OperateWindow.this.selectableEditTextHelper;
                            selectableEditTextHelper4.showCursorHandle(selectableEditTextHelper5.getMEndHandle());
                            selectableEditTextHelper6 = OperateWindow.this.selectableEditTextHelper;
                            selectableEditTextHelper7 = OperateWindow.this.selectableEditTextHelper;
                            selectableEditTextHelper6.showOperWindow(selectableEditTextHelper7.getOperWindow());
                        }
                    });
                    this.selectableEditTextHelper.getMTextView().setCursorVisible(false);
                    break;
                case 16908320:
                    Object systemService = this.selectableEditTextHelper.getMContext().getSystemService("clipboard");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText(this.selectableEditTextHelper.getMSelectionInfo().mSelectionContent, this.selectableEditTextHelper.getMSelectionInfo().mSelectionContent));
                    SelectableEditTextHelper.OnSelectListener mSelectListener = this.selectableEditTextHelper.getMSelectListener();
                    if (mSelectListener != null) {
                        mSelectListener.onTextSelected(this.selectableEditTextHelper.getMSelectionInfo().mSelectionContent);
                    }
                    this.selectableEditTextHelper.resetSelectionInfo();
                    this.selectableEditTextHelper.hideSelectView();
                    CharSequence text = this.selectableEditTextHelper.getMTextView().getText();
                    Editable editable = text instanceof Editable ? (Editable) text : null;
                    if (editable != null) {
                        int mStart = this.selectableEditTextHelper.getMSelectionInfo().getMStart();
                        int mEnd = this.selectableEditTextHelper.getMSelectionInfo().getMEnd();
                        if (a(editable, mStart, mEnd)) {
                            editable.delete(mStart, mEnd);
                        }
                    }
                    a(this.selectableEditTextHelper.getMContext(), this.selectableEditTextHelper.getMContext().getResources().getString(R.string.f1648026t), 0);
                    this.selectableEditTextHelper.getMTextView().setCursorVisible(true);
                    break;
                case 16908321:
                    Object systemService2 = this.selectableEditTextHelper.getMContext().getSystemService("clipboard");
                    Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService2, ClipData.newPlainText(this.selectableEditTextHelper.getMSelectionInfo().mSelectionContent, this.selectableEditTextHelper.getMSelectionInfo().mSelectionContent));
                    SelectableEditTextHelper.OnSelectListener mSelectListener2 = this.selectableEditTextHelper.getMSelectListener();
                    if (mSelectListener2 != null) {
                        mSelectListener2.onTextSelected(this.selectableEditTextHelper.getMSelectionInfo().mSelectionContent);
                    }
                    this.selectableEditTextHelper.resetSelectionInfo();
                    this.selectableEditTextHelper.hideSelectView();
                    d();
                    this.selectableEditTextHelper.getMTextView().setCursorVisible(true);
                    Selection.setSelection(this.selectableEditTextHelper.getMTextView().getEditableText(), this.selectableEditTextHelper.getMTextView().getSelectionEnd());
                    break;
                case 16908322:
                    this.selectableEditTextHelper.getMTextView().onTextContextMenuItem(16908322);
                    this.selectableEditTextHelper.getMTextView().setCursorVisible(true);
                    SelectableEditTextHelper selectableEditTextHelper2 = this.selectableEditTextHelper;
                    selectableEditTextHelper2.setMLastSelectStart(selectableEditTextHelper2.getMTextView().getSelectionStart());
                    break;
                default:
                    this.selectableEditTextHelper.getMTextView().setCursorVisible(true);
                    break;
            }
        } else {
            this.selectableEditTextHelper.hideSelectView();
            int selectionStart = this.selectableEditTextHelper.getMTextView().getSelectionStart();
            if (selectionStart > 0) {
                try {
                    i16 = this.selectableEditTextHelper.getMTextView().getLayout().getOffsetToLeftOf(selectionStart);
                } catch (Throwable unused) {
                    i16 = selectionStart - 1;
                }
                this.selectableEditTextHelper.selectText(i16, selectionStart);
            } else {
                try {
                    i3 = this.selectableEditTextHelper.getMTextView().getLayout().getOffsetToRightOf(selectionStart);
                } catch (Throwable unused2) {
                    i3 = selectionStart + 1;
                }
                this.selectableEditTextHelper.selectText(selectionStart, i3);
            }
            this.selectableEditTextHelper.setHide(false);
            SelectableEditTextHelper selectableEditTextHelper3 = this.selectableEditTextHelper;
            selectableEditTextHelper3.showCursorHandle(selectableEditTextHelper3.getMStartHandle());
            SelectableEditTextHelper selectableEditTextHelper4 = this.selectableEditTextHelper;
            selectableEditTextHelper4.showCursorHandle(selectableEditTextHelper4.getMEndHandle());
            SelectableEditTextHelper selectableEditTextHelper5 = this.selectableEditTextHelper;
            selectableEditTextHelper5.showOperWindow(selectableEditTextHelper5.getOperWindow());
            this.selectableEditTextHelper.getMTextView().setCursorVisible(false);
        }
        if (this.selectableEditTextHelper.getMReuseMenuItems().containsKey(Integer.valueOf(item.id))) {
            this.selectableEditTextHelper.getMTextView().onTextContextMenuItem(item.id);
            this.selectableEditTextHelper.resetSelectionInfo();
            this.selectableEditTextHelper.hideSelectView();
            this.selectableEditTextHelper.getMTextView().setCursorVisible(true);
        }
        SelectableEditTextHelper.OnMenuCallback mOnMenuCallback = this.selectableEditTextHelper.getMOnMenuCallback();
        if (mOnMenuCallback != null) {
            mOnMenuCallback.onMenuItemClicked(v3, item, curSelect);
        }
    }

    public final boolean b() {
        return true;
    }

    public final List c() {
        LinkedList linkedList = new LinkedList();
        String string = this.selectableEditTextHelper.getMContext().getResources().getString(R.string.f1650227e);
        Intrinsics.checkNotNullExpressionValue(string, "selectableEditTextHelper\u2026ing(R.string.menu_select)");
        linkedList.add(new SelectableEditTextHelper.MenuItem(string, 1, 4));
        String string2 = this.selectableEditTextHelper.getMContext().getResources().getString(android.R.string.selectAll);
        Intrinsics.checkNotNullExpressionValue(string2, "selectableEditTextHelper\u2026droid.R.string.selectAll)");
        linkedList.add(new SelectableEditTextHelper.MenuItem(string2, 16908319, 12));
        String string3 = this.selectableEditTextHelper.getMContext().getResources().getString(android.R.string.cut);
        Intrinsics.checkNotNullExpressionValue(string3, "selectableEditTextHelper\u2026ing(android.R.string.cut)");
        linkedList.add(new SelectableEditTextHelper.MenuItem(string3, 16908320, 9));
        String string4 = this.selectableEditTextHelper.getMContext().getResources().getString(android.R.string.copy);
        Intrinsics.checkNotNullExpressionValue(string4, "selectableEditTextHelper\u2026ng(android.R.string.copy)");
        linkedList.add(new SelectableEditTextHelper.MenuItem(string4, 16908321, 9));
        String string5 = this.selectableEditTextHelper.getMContext().getResources().getString(android.R.string.paste);
        Intrinsics.checkNotNullExpressionValue(string5, "selectableEditTextHelper\u2026g(android.R.string.paste)");
        linkedList.add(new SelectableEditTextHelper.MenuItem(string5, 16908322));
        return linkedList;
    }

    public final void d() {
        if (!r.d() || Build.VERSION.SDK_INT <= 32) {
            a(this.selectableEditTextHelper.getMContext(), this.selectableEditTextHelper.getMContext().getResources().getString(R.string.f1647926s), 0);
        }
    }

    public final void dismiss() {
        this.mWindow.dismiss();
    }

    @NotNull
    public final MyRecycleViewAdapter getMAdapter() {
        return this.mAdapter;
    }

    @NotNull
    public final ImageView getMArrow() {
        return this.mArrow;
    }

    @NotNull
    public final List<SelectableEditTextHelper.MenuItem> getMMenuItems() {
        return this.mMenuItems;
    }

    @NotNull
    public final RecyclerView getMRecyclerView() {
        return this.mRecyclerView;
    }

    public final boolean isShowing() {
        return this.mWindow.isShowing();
    }

    public final void setMAdapter(@NotNull MyRecycleViewAdapter myRecycleViewAdapter) {
        Intrinsics.checkNotNullParameter(myRecycleViewAdapter, "<set-?>");
        this.mAdapter = myRecycleViewAdapter;
    }

    public final void setMArrow(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mArrow = imageView;
    }

    public final void setMMenuItems(@NotNull List<SelectableEditTextHelper.MenuItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mMenuItems = list;
    }

    public final void setMRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.mRecyclerView = recyclerView;
    }

    public final void show() {
        int i3;
        a();
        View contentView = this.mWindow.getContentView();
        contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mWidth = contentView.getMeasuredWidth();
        this.mHeight = contentView.getMeasuredHeight();
        this.selectableEditTextHelper.getMTextView().getLocationInWindow(this.selectableEditTextHelper.getMTempCoors());
        Layout layout = this.selectableEditTextHelper.getMTextView().getLayout();
        int screenWidth = TextLayoutUtil.getScreenWidth(this.selectableEditTextHelper.getMContext());
        int a16 = o.a(this.selectableEditTextHelper.getMContext(), f153239i);
        int i16 = screenWidth - (a16 * 2);
        if (this.mWidth >= i16) {
            this.mWidth = i16;
        }
        int selectionStart = this.selectableEditTextHelper.getMTextView().getSelectionStart();
        int selectionEnd = this.selectableEditTextHelper.getMTextView().getSelectionEnd();
        int primaryHorizontal = ((((((int) layout.getPrimaryHorizontal(selectionStart)) + ((int) layout.getPrimaryHorizontal(selectionEnd))) / 2) + this.selectableEditTextHelper.getMTempCoors()[0]) - (this.mWidth / 2)) + this.selectableEditTextHelper.getMTextView().getPaddingLeft();
        if (selectionStart != selectionEnd && layout.getLineForOffset(selectionStart) != layout.getLineForOffset(selectionEnd)) {
            primaryHorizontal = (this.selectableEditTextHelper.getMTempCoors()[0] + (this.selectableEditTextHelper.getMTextView().getWidth() / 2)) - (this.mWidth / 2);
        }
        int lineTop = ((((layout.getLineTop(layout.getLineForOffset(selectionStart)) + this.selectableEditTextHelper.getMTempCoors()[1]) - this.mHeight) + this.selectableEditTextHelper.getMTextView().getPaddingTop()) - this.selectableEditTextHelper.getCurScrollY()) - o.a(this.selectableEditTextHelper.getMContext(), 5);
        int a17 = (this.selectableEditTextHelper.getMTempCoors()[1] - this.mHeight) - o.a(this.selectableEditTextHelper.getMContext(), 5);
        int height = ((this.selectableEditTextHelper.getMTempCoors()[1] + this.selectableEditTextHelper.getMTextView().getHeight()) - this.mHeight) - o.a(this.selectableEditTextHelper.getMContext(), 5);
        if (primaryHorizontal <= a16) {
            i3 = a16;
        } else {
            i3 = primaryHorizontal;
        }
        if (lineTop < a17) {
            lineTop = a17;
        }
        if (lineTop > height) {
            return;
        }
        int i17 = this.mWidth;
        if (i3 + i17 > screenWidth) {
            i3 = (screenWidth - i17) - a16;
        }
        ViewGroup.LayoutParams layoutParams = this.mArrow.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).leftMargin = primaryHorizontal - i3;
        this.mWindow.setElevation(8.0f);
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).scrollToPosition(0);
        }
        this.mWindow.setWidth(this.mWidth);
        n.a(TAG, "show() called finalPosX:" + i3 + " finalPosY:" + lineTop, new Object[0]);
        try {
            if (this.mWindow.isShowing()) {
                this.mWindow.update(i3, lineTop, this.mWidth, this.mHeight);
            } else {
                this.mWindow.showAtLocation(this.selectableEditTextHelper.getMTextView(), 0, i3, lineTop);
            }
        } catch (Exception e16) {
            n.b(SelectableEditTextHelper.TAG, "oper error!:%s", e16.getMessage());
        }
    }

    public final boolean a(CharSequence str, int start, int end) {
        int length;
        return str != null && end >= start && start <= (length = str.length()) && end <= length && start >= 0 && end >= 0;
    }

    public final void a(Context context, CharSequence text, int duration) {
        try {
            Toast.makeText(context, text, duration).show();
        } catch (Throwable th5) {
            n.a(TAG, th5, "show toast err", new Object[0]);
        }
    }

    public final void a() {
        int i3;
        int length = this.selectableEditTextHelper.getMTextView().getText().length();
        if (length > 0 && this.selectableEditTextHelper.getMSelectionInfo().getMStart() == 0 && this.selectableEditTextHelper.getMSelectionInfo().getMEnd() == length) {
            i3 = 1;
        } else {
            i3 = this.selectableEditTextHelper.getMSelectionInfo().getMStart() == this.selectableEditTextHelper.getMSelectionInfo().getMEnd() ? length > 0 ? 4 : 2 : 8;
        }
        LinkedList linkedList = new LinkedList();
        for (SelectableEditTextHelper.MenuItem menuItem : this.mMenuItems) {
            if (menuItem.id != 16908322 || b()) {
                if ((menuItem.visibleFlag & i3) != 0) {
                    linkedList.add(menuItem);
                }
            }
        }
        SysMenuHelper.INSTANCE.prepareReuseMenuItems(this.selectableEditTextHelper);
        if (this.selectableEditTextHelper.getMReuseMenuItems().size() > 0) {
            for (Map.Entry<Integer, CharSequence> entry : this.selectableEditTextHelper.getMReuseMenuItems().entrySet()) {
                linkedList.add(new SelectableEditTextHelper.MenuItem(entry.getValue().toString(), entry.getKey().intValue()));
            }
        }
        SelectableEditTextHelper.OnMenuCallback mOnMenuCallback = this.selectableEditTextHelper.getMOnMenuCallback();
        if (mOnMenuCallback != null) {
            mOnMenuCallback.onMenuInit(linkedList, i3);
        }
        MyRecycleViewAdapter myRecycleViewAdapter = this.mAdapter;
        myRecycleViewAdapter.mData = linkedList;
        myRecycleViewAdapter.notifyDataSetChanged();
    }
}
