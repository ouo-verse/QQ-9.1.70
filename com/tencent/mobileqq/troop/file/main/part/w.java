package com.tencent.mobileqq.troop.file.main.part;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.transfile.AbstractImageDownloader;
import com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.bc;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.el;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.PopupMenuDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 32\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0018\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010)\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010.\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/part/w;", "Lcom/tencent/biz/richframework/part/Part;", "", "Q9", "", "isRootOwner", "U9", "R9", "", "Lcom/tencent/widget/PopupMenuDialog$MenuItem;", "menuOwnerItems", "Lcom/tencent/widget/PopupMenuDialog;", "I9", "menuItems", "F9", "O9", "N9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "d", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "getViewModel", "()Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "viewModel", "e", "Z", "isShowTeamWorkEntrance", "f", "Landroid/view/View;", "contentView", tl.h.F, "titleView", "i", "Lcom/tencent/widget/PopupMenuDialog;", "ownerPopupMenu", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "normalPopupMenu", "L9", "()Ljava/lang/String;", "mFolderId", "M9", "troopUinStr", "<init>", "(Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class w extends Part {
    private static final int[] D = {R.string.elm, R.string.eln, R.string.elq, R.string.ekw, R.string.ekt};
    private static final int[] E = {R.drawable.qfile_file_troopfile_list_menu_upload, R.drawable.qfile_file_troopfile_list_menu_upload_img, R.drawable.qfile_file_troopfile_list_menu_upload_video, R.drawable.qfile_file_troopfile_list_menu_create_docs, R.drawable.qfile_file_troopfile_list_menu_create_folder};
    private static final int[] F = {R.string.elm, R.string.eln, R.string.elq, R.string.ekw};
    private static final int[] G = {R.drawable.qfile_file_troopfile_list_menu_upload, R.drawable.qfile_file_troopfile_list_menu_upload_img, R.drawable.qfile_file_troopfile_list_menu_upload_video, R.drawable.qfile_file_troopfile_list_menu_create_docs};
    private static final int[] H = {R.string.elm, R.string.eln, R.string.elq};
    private static final int[] I = {R.drawable.qfile_file_troopfile_list_menu_upload, R.drawable.qfile_file_troopfile_list_menu_upload_img, R.drawable.qfile_file_troopfile_list_menu_upload_video};

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopFileMainVM viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isShowTeamWorkEntrance;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View contentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View titleView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private PopupMenuDialog ownerPopupMenu;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private PopupMenuDialog normalPopupMenu;

    public w(TroopFileMainVM viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    private final PopupMenuDialog F9(List<? extends PopupMenuDialog.MenuItem> menuItems) {
        return PopupMenuDialog.build(getActivity(), menuItems, new PopupMenuDialog.OnClickActionListener() { // from class: com.tencent.mobileqq.troop.file.main.part.r
            @Override // com.tencent.widget.PopupMenuDialog.OnClickActionListener
            public final void onClickAction(PopupMenuDialog.MenuItem menuItem) {
                w.G9(w.this, menuItem);
            }
        }, new PopupMenuDialog.OnDismissListener() { // from class: com.tencent.mobileqq.troop.file.main.part.s
            @Override // com.tencent.widget.PopupMenuDialog.OnDismissListener
            public final void onDismiss() {
                w.H9(w.this);
            }
        }, ViewUtils.dip2px(200.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(w this$0, PopupMenuDialog.MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.file.data.d.f(this$0.getActivity(), this$0.ownerPopupMenu, menuItem);
        int i3 = menuItem.f384641id;
        if (i3 == 0) {
            this$0.broadcastMessage("select_file_upload", Unit.INSTANCE);
        } else if (i3 == 1) {
            this$0.broadcastMessage("select_image_upload", Unit.INSTANCE);
        } else if (i3 == 2) {
            this$0.broadcastMessage("select_video_upload", Unit.INSTANCE);
        } else if (i3 == 3) {
            this$0.O9();
        }
        View view = this$0.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        view.setImportantForAccessibility(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(w this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        view.setImportantForAccessibility(1);
    }

    private final PopupMenuDialog I9(List<? extends PopupMenuDialog.MenuItem> menuOwnerItems) {
        return PopupMenuDialog.build(getActivity(), menuOwnerItems, new PopupMenuDialog.OnClickActionListener() { // from class: com.tencent.mobileqq.troop.file.main.part.t
            @Override // com.tencent.widget.PopupMenuDialog.OnClickActionListener
            public final void onClickAction(PopupMenuDialog.MenuItem menuItem) {
                w.J9(w.this, menuItem);
            }
        }, new PopupMenuDialog.OnDismissListener() { // from class: com.tencent.mobileqq.troop.file.main.part.u
            @Override // com.tencent.widget.PopupMenuDialog.OnDismissListener
            public final void onDismiss() {
                w.K9(w.this);
            }
        }, ViewUtils.dip2px(200.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(w this$0, PopupMenuDialog.MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.file.data.d.f(this$0.getActivity(), this$0.ownerPopupMenu, menuItem);
        int i3 = menuItem.f384641id;
        if (i3 == 0) {
            this$0.broadcastMessage("select_file_upload", Unit.INSTANCE);
        } else if (i3 == 1) {
            this$0.broadcastMessage("select_image_upload", Unit.INSTANCE);
        } else if (i3 == 2) {
            this$0.broadcastMessage("select_video_upload", Unit.INSTANCE);
        } else if (i3 == 3) {
            this$0.O9();
        } else if (i3 == 4) {
            this$0.N9();
        }
        View view = this$0.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        view.setImportantForAccessibility(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(w this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        view.setImportantForAccessibility(1);
    }

    private final String L9() {
        return this.viewModel.T1().folderId;
    }

    private final String M9() {
        return this.viewModel.T1().troopUinStr;
    }

    private final void N9() {
        if (TroopFileUtils.d(bc.a(this), getActivity(), this.viewModel.T1().troopUinL) == 0) {
            return;
        }
        broadcastMessage("show_create_or_rename_folder_dialog", new ks2.a(bc.f(this, R.string.epv), null, "", "", 0));
        ReportController.o(bc.a(this), "P_CliOper", "Grp_files", "", "file", "Clk_new", 0, 0, M9(), "0", "", "");
    }

    private final void O9() {
        TroopInfo k3;
        String i3 = QFileUtils.i(bc.a(this), this.viewModel.T1().troopUinL);
        if (!TextUtils.isEmpty(i3)) {
            QQToast.makeText(getActivity(), i3, 0).show();
            return;
        }
        Manager manager = bc.a(this).getManager(QQManagerFactory.TROOP_MANAGER);
        TroopManager troopManager = manager instanceof TroopManager ? (TroopManager) manager : null;
        if (troopManager == null || (k3 = troopManager.k(this.viewModel.T1().troopUinStr)) == null) {
            return;
        }
        final long j3 = k3.dwGroupClassExt;
        final el elVar = new el(getActivity());
        elVar.c(new el.a() { // from class: com.tencent.mobileqq.troop.file.main.part.v
            @Override // com.tencent.mobileqq.utils.el.a
            public final void a(int i16) {
                w.P9(el.this, this, j3, i16);
            }
        });
        elVar.d();
    }

    private final void R9() {
        PopupMenuDialog.MenuItem menuItem;
        PopupMenuDialog.MenuItem menuItem2;
        List<? extends PopupMenuDialog.MenuItem> arrayList = new ArrayList<>();
        int i3 = 0;
        if (Intrinsics.areEqual("/", L9())) {
            int length = F.length;
            for (int i16 = 0; i16 < length; i16++) {
                PopupMenuDialog.MenuItem menuItem3 = new PopupMenuDialog.MenuItem();
                menuItem3.f384641id = i16;
                String f16 = bc.f(this, F[i16]);
                menuItem3.title = f16;
                menuItem3.contentDescription = f16;
                menuItem3.iconId = G[i16];
                arrayList.add(menuItem3);
            }
        } else {
            int length2 = H.length;
            for (int i17 = 0; i17 < length2; i17++) {
                PopupMenuDialog.MenuItem menuItem4 = new PopupMenuDialog.MenuItem();
                menuItem4.f384641id = i17;
                String f17 = bc.f(this, H[i17]);
                menuItem4.title = f17;
                menuItem4.contentDescription = f17;
                menuItem4.iconId = I[i17];
                arrayList.add(menuItem4);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (Intrinsics.areEqual("/", L9())) {
            int length3 = D.length;
            while (i3 < length3) {
                PopupMenuDialog.MenuItem menuItem5 = new PopupMenuDialog.MenuItem();
                menuItem5.f384641id = i3;
                String f18 = bc.f(this, D[i3]);
                menuItem5.title = f18;
                menuItem5.contentDescription = f18;
                menuItem5.iconId = E[i3];
                arrayList2.add(menuItem5);
                i3++;
            }
        } else {
            int length4 = H.length;
            while (i3 < length4) {
                PopupMenuDialog.MenuItem menuItem6 = new PopupMenuDialog.MenuItem();
                menuItem6.f384641id = i3;
                String f19 = bc.f(this, H[i3]);
                menuItem6.title = f19;
                menuItem6.contentDescription = f19;
                menuItem6.iconId = I[i3];
                arrayList2.add(menuItem6);
                i3++;
            }
        }
        if (!this.isShowTeamWorkEntrance) {
            Iterator<? extends PopupMenuDialog.MenuItem> it = arrayList.iterator();
            while (true) {
                menuItem = null;
                if (it.hasNext()) {
                    menuItem2 = it.next();
                    if (menuItem2.iconId == R.drawable.qfile_file_troopfile_list_menu_create_docs) {
                        break;
                    }
                } else {
                    menuItem2 = null;
                    break;
                }
            }
            if (menuItem2 != null) {
                arrayList.remove(menuItem2);
            }
            Iterator<? extends PopupMenuDialog.MenuItem> it5 = arrayList2.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                PopupMenuDialog.MenuItem next = it5.next();
                if (next.iconId == R.drawable.qfile_file_troopfile_list_menu_create_docs) {
                    menuItem = next;
                    break;
                }
            }
            if (menuItem != null) {
                arrayList2.remove(menuItem);
            }
        }
        this.ownerPopupMenu = I9(arrayList2);
        com.tencent.mobileqq.troop.file.data.d.k(getActivity(), this.ownerPopupMenu, M9());
        this.normalPopupMenu = F9(arrayList);
        com.tencent.mobileqq.troop.file.data.d.k(getActivity(), this.normalPopupMenu, M9());
        PopupMenuDialog popupMenuDialog = this.ownerPopupMenu;
        Intrinsics.checkNotNull(popupMenuDialog);
        popupMenuDialog.setTouchInterceptor(new View.OnTouchListener() { // from class: com.tencent.mobileqq.troop.file.main.part.p
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean S9;
                S9 = w.S9(w.this, view, motionEvent);
                return S9;
            }
        });
        PopupMenuDialog popupMenuDialog2 = this.normalPopupMenu;
        Intrinsics.checkNotNull(popupMenuDialog2);
        popupMenuDialog2.setTouchInterceptor(new View.OnTouchListener() { // from class: com.tencent.mobileqq.troop.file.main.part.q
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean T9;
                T9 = w.T9(w.this, view, motionEvent);
                return T9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S9(w this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = null;
        if (motionEvent.getAction() == 4) {
            PopupMenuDialog popupMenuDialog = this$0.ownerPopupMenu;
            Intrinsics.checkNotNull(popupMenuDialog);
            popupMenuDialog.dismiss();
            View view3 = this$0.contentView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
            } else {
                view2 = view3;
            }
            view2.setImportantForAccessibility(1);
            return true;
        }
        View view4 = this$0.contentView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        } else {
            view2 = view4;
        }
        view2.setImportantForAccessibility(1);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean T9(w this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = null;
        if (motionEvent.getAction() == 4) {
            PopupMenuDialog popupMenuDialog = this$0.normalPopupMenu;
            Intrinsics.checkNotNull(popupMenuDialog);
            popupMenuDialog.dismiss();
            View view3 = this$0.contentView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
            } else {
                view2 = view3;
            }
            view2.setImportantForAccessibility(1);
            return true;
        }
        View view4 = this$0.contentView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        } else {
            view2 = view4;
        }
        view2.setImportantForAccessibility(1);
        return false;
    }

    private final void U9(boolean isRootOwner) {
        PopupMenuDialog popupMenuDialog;
        View view = this.contentView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        view.setImportantForAccessibility(4);
        R9();
        if (isRootOwner) {
            popupMenuDialog = this.ownerPopupMenu;
        } else {
            popupMenuDialog = this.normalPopupMenu;
        }
        Intrinsics.checkNotNull(popupMenuDialog);
        View view3 = this.titleView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            view3 = null;
        }
        int width = (view3.getWidth() - popupMenuDialog.getWidth()) - getActivity().getResources().getDimensionPixelSize(R.dimen.au7);
        View view4 = this.titleView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        } else {
            view2 = view4;
        }
        popupMenuDialog.showAsDropDown(view2, width, 0);
        com.tencent.mobileqq.troop.file.data.d.g(getActivity(), popupMenuDialog);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "set_show_team_work_entrance")) {
            Boolean bool = args instanceof Boolean ? (Boolean) args : null;
            this.isShowTeamWorkEntrance = bool != null ? bool.booleanValue() : false;
        } else if (Intrinsics.areEqual(action, "show_popup_menu")) {
            Q9();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Q9() {
        byte b16;
        if (bc.a(this) == null) {
            return;
        }
        Manager manager = bc.a(this).getManager(QQManagerFactory.TROOP_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
        TroopInfo B = ((TroopManager) manager).B(M9());
        if (B != null) {
            if (B.isNeedInterceptOnBlockTroop()) {
                QQToast.makeText(getActivity(), 1, "\u64cd\u4f5c\u5931\u8d25\uff0c\u8be5\u7fa4\u5df2\u88ab\u5c01\u7981", 0).show();
                return;
            }
            if ((B.isTroopAdmin(bc.a(this).getCurrentAccountUin()) || B.isTroopOwner(bc.a(this).getCurrentAccountUin())) && Intrinsics.areEqual("/", L9())) {
                b16 = true;
                if (b16 == false) {
                    U9(true);
                    ReportController.o(bc.a(this), "P_CliOper", "Grp_files", "", "file", "new_exp", 0, 0, M9(), "0", "", "");
                } else {
                    U9(false);
                }
                QQAppInterface a16 = bc.a(this);
                String M9 = M9();
                int i3 = !Intrinsics.areEqual("/", L9()) ? 1 : 0;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(i3);
                ReportController.o(a16, "P_CliOper", "Grp_files", "", "oper", "Clk_new", 0, 0, M9, sb5.toString(), "", "");
            }
        }
        b16 = false;
        if (b16 == false) {
        }
        QQAppInterface a162 = bc.a(this);
        String M92 = M9();
        int i36 = !Intrinsics.areEqual("/", L9()) ? 1 : 0;
        StringBuilder sb52 = new StringBuilder();
        sb52.append(i36);
        ReportController.o(a162, "P_CliOper", "Grp_files", "", "oper", "Clk_new", 0, 0, M92, sb52.toString(), "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(el sheetBuilder, w this$0, long j3, int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(sheetBuilder, "$sheetBuilder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i17 = 1;
        if (i3 != 1) {
            int i18 = 2;
            if (i3 != 2) {
                i18 = 3;
                if (i3 != 3) {
                    i16 = 1;
                    i17 = 0;
                    sheetBuilder.b();
                    ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).openTroopTemplatePreviewUrlWithCheck(bc.a(this$0), this$0.getActivity(), i16, AbstractImageDownloader.TAG_GROUP, this$0.viewModel.T1().troopUinL, j3, bc.a(this$0).getLongAccountUin());
                    QQAppInterface a16 = bc.a(this$0);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(j3);
                    String sb6 = sb5.toString();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(i17);
                    ReportController.o(a16, "dc00898", "", "", "0X8009C64", "0X8009C64", 0, 0, "", "", sb6, sb7.toString());
                }
            }
            i17 = i18;
        }
        i16 = i17;
        sheetBuilder.b();
        ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).openTroopTemplatePreviewUrlWithCheck(bc.a(this$0), this$0.getActivity(), i16, AbstractImageDownloader.TAG_GROUP, this$0.viewModel.T1().troopUinL, j3, bc.a(this$0).getLongAccountUin());
        QQAppInterface a162 = bc.a(this$0);
        StringBuilder sb52 = new StringBuilder();
        sb52.append(j3);
        String sb62 = sb52.toString();
        StringBuilder sb72 = new StringBuilder();
        sb72.append(i17);
        ReportController.o(a162, "dc00898", "", "", "0X8009C64", "0X8009C64", 0, 0, "", "", sb62, sb72.toString());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.jyd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.troop_file_assistant)");
        this.contentView = findViewById;
        View findViewById2 = rootView.findViewById(R.id.rlCommenTitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.rlCommenTitle)");
        this.titleView = findViewById2;
    }
}
