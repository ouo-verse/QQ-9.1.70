package lx1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private final int f415729a;

    /* renamed from: b, reason: collision with root package name */
    private final View f415730b;

    /* renamed from: c, reason: collision with root package name */
    private final View f415731c;

    /* renamed from: d, reason: collision with root package name */
    private final View f415732d;

    /* renamed from: e, reason: collision with root package name */
    private final View f415733e;

    /* renamed from: f, reason: collision with root package name */
    private final Activity f415734f;

    /* renamed from: g, reason: collision with root package name */
    private View.OnLayoutChangeListener f415735g;

    public d(Activity activity, View view, View view2) {
        super(view, -1, QQGuildUIUtil.e(36.0f, activity.getResources()));
        this.f415733e = view2;
        this.f415729a = QQGuildUIUtil.e(36.0f, activity.getResources());
        this.f415730b = view.findViewById(R.id.f99465pv);
        this.f415731c = view.findViewById(R.id.f99455pu);
        this.f415732d = view.findViewById(R.id.f7624415);
        this.f415734f = activity;
        setOutsideTouchable(true);
        setTouchable(true);
    }

    public static d b(Activity activity, View view) {
        return new d(activity, LayoutInflater.from(activity).inflate(R.layout.f168162f50, (ViewGroup) null), view);
    }

    private View.OnLayoutChangeListener c() {
        if (this.f415735g == null) {
            this.f415735g = new View.OnLayoutChangeListener() { // from class: lx1.c
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    d.this.d(view, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            };
        }
        return this.f415735g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        View view2 = this.f415733e;
        update(view2, 0, -(view2.getHeight() + this.f415729a), -1, -1);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (QLog.isColorLevel()) {
            QLog.d("GuildRobotTag:RobotAtTooltip", 1, "dismiss");
        }
        super.dismiss();
    }

    public void e(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotAtTooltip", 2, "showTooltip, tooltipType:" + i3);
        }
        if (i3 != 0) {
            if (i3 == 1) {
                this.f415730b.setVisibility(8);
                this.f415731c.setVisibility(0);
            }
        } else {
            this.f415730b.setVisibility(0);
            this.f415731c.setVisibility(8);
        }
        this.f415733e.addOnLayoutChangeListener(c());
        if (isShowing()) {
            if (QLog.isColorLevel()) {
                QLog.i("GuildRobotTag:RobotAtTooltip", 2, "showTooltip isShowing, tooltipType:" + i3);
                return;
            }
            return;
        }
        ViewCompat.setBackground(this.f415732d, ResourcesCompat.getDrawable(this.f415734f.getResources(), R.drawable.guild_robot_at_inline_loading_bg, this.f415734f.getTheme()));
        View view = this.f415733e;
        showAsDropDown(view, 0, -(view.getHeight() + this.f415729a));
    }
}
