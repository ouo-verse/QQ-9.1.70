package fx1;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.robot.components.guilds.RobotCommonGuildFragment;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildRsp;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends RecyclerView.Adapter<a> {
    private List<GProRobotCommonGuildInfo> C;
    private RobotCommonGuildFragment D;
    private boolean E;

    /* renamed from: m, reason: collision with root package name */
    private Context f400916m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a extends RecyclerView.ViewHolder {
        public LinearLayout E;
        public ImageView F;
        public TextView G;

        public a(@NonNull View view) {
            super(view);
            l(view);
        }

        private void l(View view) {
            this.E = (LinearLayout) view.findViewById(R.id.b8q);
            this.F = (ImageView) view.findViewById(R.id.wic);
            this.G = (TextView) view.findViewById(R.id.wrw);
        }
    }

    public b(Context context, GProRobotCommonGuildRsp gProRobotCommonGuildRsp, RobotCommonGuildFragment robotCommonGuildFragment) {
        this.f400916m = context;
        this.D = robotCommonGuildFragment;
        this.C = gProRobotCommonGuildRsp.getGuilds();
    }

    private void j0(a aVar, GProRobotCommonGuildInfo gProRobotCommonGuildInfo) {
        VideoReport.setElementId(aVar.E, "em_qqrobot_signnal_channel");
        VideoReport.setElementReuseIdentifier(aVar.E, String.valueOf(gProRobotCommonGuildInfo.getGuildId()));
        VideoReport.setElementExposePolicy(aVar.E, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(aVar.E, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(aVar.E, EndExposurePolicy.REPORT_ALL);
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_signnal_channel_name", gProRobotCommonGuildInfo.getGuildName());
        hashMap.put("qq_robot_signnal_channel_id", Long.valueOf(gProRobotCommonGuildInfo.getGuildId()));
        VideoReport.setElementParams(aVar.E, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(GProRobotCommonGuildInfo gProRobotCommonGuildInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String valueOf = String.valueOf(gProRobotCommonGuildInfo.getGuildId());
        if (!ch.j0(valueOf)) {
            GuildJumpUtil.r(this.f400916m, valueOf);
            this.E = true;
            RobotCommonGuildFragment robotCommonGuildFragment = this.D;
            if (robotCommonGuildFragment != null) {
                robotCommonGuildFragment.dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<GProRobotCommonGuildInfo> list = this.C;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public boolean k0() {
        return this.E;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005d  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(@NonNull a aVar, int i3) {
        URLDrawable uRLDrawable;
        final GProRobotCommonGuildInfo gProRobotCommonGuildInfo = this.C.get(i3);
        aVar.G.setText(gProRobotCommonGuildInfo.getGuildName());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            String guildAvatarUrl = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildAvatarUrl(String.valueOf(gProRobotCommonGuildInfo.getGuildId()), 0);
            if (!TextUtils.isEmpty(guildAvatarUrl)) {
                try {
                    uRLDrawable = URLDrawable.getDrawable(guildAvatarUrl, URLDrawable.URLDrawableOptions.obtain());
                } catch (Exception e16) {
                    QLog.e("RobotCommonGuildAdapter", 1, "getDrawable, " + e16);
                }
                if (uRLDrawable != null) {
                    QLog.d("RobotCommonGuildAdapter", 1, "url of " + guildAvatarUrl + " is empty");
                } else {
                    aVar.F.setImageDrawable(uRLDrawable);
                }
                aVar.E.setOnClickListener(new View.OnClickListener() { // from class: fx1.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        b.this.l0(gProRobotCommonGuildInfo, view);
                    }
                });
            }
            uRLDrawable = null;
            if (uRLDrawable != null) {
            }
            aVar.E.setOnClickListener(new View.OnClickListener() { // from class: fx1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.this.l0(gProRobotCommonGuildInfo, view);
                }
            });
        } else {
            QLog.d("RobotCommonGuildAdapter", 1, "appRuntime == null");
        }
        j0(aVar, gProRobotCommonGuildInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(this.f400916m).inflate(R.layout.f58, viewGroup, false));
    }
}
