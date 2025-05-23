package com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.timi.game.liveroom.impl.room.match.TGAudienceMatchTabView;
import java.util.ArrayList;
import java.util.List;
import qi2.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LinkMicListView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private TGAudienceMatchTabView f271759d;

    /* renamed from: e, reason: collision with root package name */
    private ChatRoomViewPager f271760e;

    public LinkMicListView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            b();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
    }

    private int a() {
        return 0;
    }

    private void b() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fm8, (ViewGroup) this, true);
        this.f271759d = (TGAudienceMatchTabView) inflate.findViewById(R.id.tabView);
        this.f271760e = (ChatRoomViewPager) inflate.findViewById(R.id.f916255o);
        c();
    }

    private void c() {
        d();
        this.f271759d.setColorSelect(-1);
        this.f271759d.setColorUnSelect(2063597567);
        this.f271759d.setLineBgDrawableRes(R.drawable.k1h);
        this.f271759d.setViewPager(this.f271760e);
        this.f271759d.setNeedBottomLine(false);
        this.f271760e.c();
    }

    private void d() {
        ArrayList arrayList = new ArrayList();
        if (this.f271760e.b() > 0) {
            arrayList.add("\u8fde\u9ea6\u7533\u8bf7 (" + this.f271760e.b() + ")");
        } else {
            arrayList.add("\u8fde\u9ea6\u7533\u8bf7");
        }
        arrayList.add("\u9080\u8bf7\u8fde\u9ea6");
        TGAudienceMatchTabView tGAudienceMatchTabView = this.f271759d;
        tGAudienceMatchTabView.setData(arrayList, tGAudienceMatchTabView.getCurrentPos());
    }

    public void setCallBack(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f271760e.setCallBack(aVar);
        ChatRoomViewPager chatRoomViewPager = this.f271760e;
        if (a() > 0) {
            i3 = 0;
        }
        chatRoomViewPager.setCurrentItem(i3);
    }

    public void setInviteList(List<qn3.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            this.f271760e.setInviteList(list);
        }
    }

    public void setWaitingList(List<qn3.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        } else {
            this.f271760e.setWaitingList(list);
            d();
        }
    }

    public LinkMicListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            b();
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public LinkMicListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            b();
        } else {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
