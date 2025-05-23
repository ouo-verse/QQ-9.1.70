package com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.LinkMicListView;
import com.tencent.mobileqq.qqlive.room.multichat.view.mananger.setting.SettingView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* loaded from: classes17.dex */
public class ChatRoomManagerPanel extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private View f271712d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f271713e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f271714f;

    /* renamed from: h, reason: collision with root package name */
    private LinkMicListView f271715h;

    /* renamed from: i, reason: collision with root package name */
    private SettingView f271716i;

    /* renamed from: m, reason: collision with root package name */
    private PopupWindow f271717m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.ChatRoomManagerPanel$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        class DialogInterfaceOnClickListenerC8374a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnClickListenerC8374a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                dialogInterface.dismiss();
                ChatRoomManagerPanel.b(ChatRoomManagerPanel.this);
                if (ChatRoomManagerPanel.this.f271717m != null) {
                    ChatRoomManagerPanel.this.f271717m.dismiss();
                }
            }
        }

        /* loaded from: classes17.dex */
        class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatRoomManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                DialogUtil.createCustomDialog(ChatRoomManagerPanel.this.getContext(), 230, ChatRoomManagerPanel.this.getContext().getString(R.string.f168942h0), "", new DialogInterfaceOnClickListenerC8374a(), new b()).show();
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(ChatRoomManagerPanel.this.f271714f, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateManageElementParam(1));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatRoomManagerPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ChatRoomManagerPanel.this.f271716i.setVisibility(0);
                ChatRoomManagerPanel.this.f271716i.k();
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(ChatRoomManagerPanel.this.f271713e, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateManageElementParam(0));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class c implements SettingView.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatRoomManagerPanel.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.multichat.view.mananger.setting.SettingView.e
        public void onBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ChatRoomManagerPanel.this.f271716i.setVisibility(8);
            }
        }
    }

    public ChatRoomManagerPanel(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            i();
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
    }

    static /* bridge */ /* synthetic */ qi2.a b(ChatRoomManagerPanel chatRoomManagerPanel) {
        chatRoomManagerPanel.getClass();
        return null;
    }

    private void f(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tzd);
        this.f271714f = textView;
        textView.setOnClickListener(new a());
    }

    private void g(View view) {
        this.f271715h = (LinkMicListView) view.findViewById(R.id.yiy);
    }

    private void h(View view) {
        TextView textView = (TextView) view.findViewById(R.id.f780245y);
        this.f271713e = textView;
        textView.setOnClickListener(new b());
        SettingView settingView = (SettingView) view.findViewById(R.id.f83714ka);
        this.f271716i = settingView;
        settingView.setUiCallback(new c());
    }

    private void i() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168316fm4, (ViewGroup) this, true);
        this.f271712d = inflate;
        f(inflate);
        h(this.f271712d);
        g(this.f271712d);
    }

    public void setInviteList(List<qn3.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
        } else {
            this.f271715h.setInviteList(list);
        }
    }

    public void setLinkCallBack(qi2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f271715h.setCallBack(null);
        }
    }

    public void setPopupWin(PopupWindow popupWindow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) popupWindow);
        } else {
            this.f271717m = popupWindow;
        }
    }

    public void setSettingParam(boolean z16, boolean z17, boolean z18, qi2.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), cVar);
        } else {
            this.f271716i.setSettingParam(z16, z17, z18, cVar);
        }
    }

    public void setWaitingList(List<qn3.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
        } else {
            this.f271715h.setWaitingList(list);
        }
    }

    public ChatRoomManagerPanel(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            i();
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public ChatRoomManagerPanel(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            i();
        } else {
            iPatchRedirector.redirect((short) 6, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
