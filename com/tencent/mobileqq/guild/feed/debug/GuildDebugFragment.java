package com.tencent.mobileqq.guild.feed.debug;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.GuildQUIProfileFragmentUtilsKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.contact.IContactExtApi;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildHomeApi;
import com.tencent.mobileqq.guild.api.IGuildRiskMemberApi;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.guild.performance.report.data.GuildPerformanceInfo;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.Switch;
import f12.q;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildDebugFragment extends QPublicBaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private Switch C;
    private Switch D;
    private TextView E;
    private TextView F;
    private EditText G;
    private Button H;
    private Spinner I;
    private String[] J;
    private Switch L;
    private Switch M;
    private Switch N;
    private Switch P;
    private Switch R;
    private Switch S;
    private Switch T;
    private Switch U;
    private EditText V;
    private Button W;
    private LinearLayout X;
    private View Y;
    private x12.a Z;

    /* renamed from: a0, reason: collision with root package name */
    private RelativeLayout f218411a0;

    /* renamed from: b0, reason: collision with root package name */
    private Switch f218412b0;

    /* renamed from: c0, reason: collision with root package name */
    private Switch f218413c0;

    /* renamed from: d0, reason: collision with root package name */
    private EditText f218414d0;
    private int K = 0;
    private com.tencent.mobileqq.guild.performance.report.data.a Q = new com.tencent.mobileqq.guild.performance.report.data.a() { // from class: com.tencent.mobileqq.guild.feed.debug.b
        @Override // com.tencent.mobileqq.guild.performance.report.data.a
        public final void a(GuildPerformanceInfo guildPerformanceInfo, boolean z16) {
            q.j(guildPerformanceInfo, z16);
        }
    };

    /* renamed from: e0, reason: collision with root package name */
    private HashMap<String, c> f218415e0 = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface c {
        void invoke();
    }

    private void Ah() {
        this.f218415e0.put("\u53d1\u8a00\u7ba1\u7406\u5f15\u5bfc\u8bb0\u5f55\u6e05\u7406", new c() { // from class: com.tencent.mobileqq.guild.feed.debug.d
            @Override // com.tencent.mobileqq.guild.feed.debug.GuildDebugFragment.c
            public final void invoke() {
                GuildDebugFragment.this.zh();
            }
        });
    }

    private void Bh(View view) {
        Switch r26 = (Switch) view.findViewById(R.id.f57882oi);
        this.M = r26;
        r26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.feed.debug.h
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildDebugFragment.Hh(compoundButton, z16);
            }
        });
    }

    private void Ch(View view) {
        Switch r26 = (Switch) view.findViewById(R.id.f57962oq);
        r26.setChecked(com.tencent.mobileqq.guild.quiprofile.d.f231936g);
        r26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.feed.debug.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildDebugFragment.Ih(compoundButton, z16);
            }
        });
    }

    private void Dh(View view) {
        Switch r26 = (Switch) view.findViewById(R.id.f57972or);
        r26.setChecked(GuildQUIProfileFragmentUtilsKt.getGUILD_PROFILE_SWITCH_FOR_DEBUG());
        r26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.feed.debug.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildDebugFragment.Jh(compoundButton, z16);
            }
        });
    }

    private void Eh(View view) {
        this.E = (TextView) view.findViewById(R.id.f58142p8);
        this.H = (Button) view.findViewById(R.id.f57982os);
        view.findViewById(R.id.v37).setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I = (Spinner) view.findViewById(R.id.f58002ou);
        this.J = getResources().getStringArray(R.array.c_);
        this.I.setAdapter((SpinnerAdapter) new ArrayAdapter(view.getContext(), R.layout.eka, this.J));
        this.I.setOnItemSelectedListener(new b());
        this.I.setSelection(0);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.wlz);
        this.f218411a0 = relativeLayout;
        relativeLayout.setOnClickListener(this);
    }

    private void Fh(View view) {
        Switch r26 = (Switch) view.findViewById(R.id.f57952op);
        this.L = r26;
        r26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.feed.debug.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildDebugFragment.this.Kh(compoundButton, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Gh(Map.Entry entry, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((c) entry.getValue()).invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Hh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        ((IGuildHomeApi) QRoute.api(IGuildHomeApi.class)).changeGuildHomeTabListLog(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ih(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        com.tencent.mobileqq.guild.quiprofile.d.f231936g = z16;
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Jh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        GuildQUIProfileFragmentUtilsKt.setGUILD_PROFILE_SWITCH_FOR_DEBUG(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (z16) {
            ((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).addCallback(this.Q);
        } else {
            ((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).removeCallback(this.Q);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Lh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        j.b().e("guild_new_upload_media_service", z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private void Mh(boolean z16) {
        if (z16) {
            if (!((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext())) {
                this.U.setOnCheckedChangeListener(null);
                this.U.setChecked(false);
                this.U.setOnCheckedChangeListener(this);
                ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(getActivity());
                return;
            }
            com.tencent.mobileqq.guild.util.trace.a.c(BaseApplication.getContext());
            return;
        }
        com.tencent.mobileqq.guild.util.trace.a.a();
    }

    private void Nh(boolean z16) {
        if (z16) {
            if (!((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext())) {
                this.T.setOnCheckedChangeListener(null);
                this.T.setChecked(false);
                this.T.setOnCheckedChangeListener(this);
                ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(getActivity());
                return;
            }
            com.tencent.mobileqq.guild.util.trace.k.d(BaseApplication.getContext());
            return;
        }
        com.tencent.mobileqq.guild.util.trace.k.a();
    }

    private void Oh(boolean z16) {
        j.b().e("key_aio_msgId_enabled", z16);
    }

    private void initData() {
        this.C.setChecked(j.b().a("key_html_offline_enabled", true));
        this.D.setChecked(j.b().a("key_feed_detail_time_cost_view_enabled", false));
        this.R.setChecked(j.b().a("key_aio_msgId_enabled", false));
        this.N.setChecked(j.b().a("key_feed_list_load_enabled", false));
        this.S.setChecked(j.b().a("key_guild_trace_enabled", false));
        this.T.setChecked(com.tencent.mobileqq.guild.util.trace.k.b());
        Switch r06 = (Switch) this.Y.findViewById(R.id.f57812ob);
        r06.setOnCheckedChangeListener(this);
        r06.setChecked(j.b().a("key_disable_aio_web_preload", false));
        boolean a16 = j.b().a("key_jump_debug_log_enabled", false);
        this.Z.f446882y.setOnCheckedChangeListener(this);
        this.Z.f446882y.setChecked(a16);
        boolean a17 = j.b().a("key_empty_subscribe_guild_content", false);
        this.Z.f446872o.setOnCheckedChangeListener(this);
        this.Z.f446872o.setChecked(a17);
        boolean a18 = j.b().a("key_disable_subscribe_guild_preload_switch", false);
        this.Z.f446871n.setOnCheckedChangeListener(this);
        this.Z.f446871n.setChecked(a18);
        boolean a19 = j.b().a("KEY_ENABLE_STICKY_CARD_LIVE_VOICE", false);
        this.Z.f446874q.setOnCheckedChangeListener(this);
        this.Z.f446874q.setChecked(a19);
        boolean a26 = j.b().a("KEY_ENABLE_NEW_USER_DISCOVER", false);
        this.Z.f446873p.setOnCheckedChangeListener(this);
        this.Z.f446873p.setChecked(a26);
        boolean a27 = j.b().a("KEY_ENABLE_TOAST_FOR_TIANSHU", false);
        this.Z.f446875r.setOnCheckedChangeListener(this);
        this.Z.f446875r.setChecked(a27);
        boolean a28 = j.b().a("key_disable_guild_speak_manage_guide_time_record", false);
        this.Z.f446870m.setOnCheckedChangeListener(this);
        this.Z.f446870m.setChecked(a28);
        boolean a29 = j.b().a("key_md_break_simple_enabled", false);
        this.Z.A.setOnCheckedChangeListener(this);
        this.Z.A.setChecked(a29);
        boolean a36 = j.b().a("KEY_ENABLE_FEED_SQUARE_CLIP_INFO", false);
        this.Z.f446878u.setOnCheckedChangeListener(this);
        this.Z.f446878u.setChecked(a36);
        for (final Map.Entry<String, c> entry : this.f218415e0.entrySet()) {
            Button button = new Button(getContext());
            button.setText(entry.getKey());
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.debug.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildDebugFragment.Gh(entry, view);
                }
            });
            this.X.addView(button);
        }
        this.F.setText(j.b().c("key_feed_open_anim_duration", "200"));
        this.G.setText(String.valueOf(((IGuildRiskMemberApi) QRoute.api(IGuildRiskMemberApi.class)).getMaxTinyIdCount()));
        this.f218414d0.setText(j.b().c("KEY_ENABLE_GUILDTAB_METHOD_TRACE_DURATION", "1000"));
        this.f218412b0.setChecked(j.b().a("KEY_ENABLE_GUILDTAB_METHOD_TRACE", false));
        this.f218413c0.setChecked(j.b().a("key_always_show_guild_folder", false));
    }

    private void initView(View view) {
        View findViewById = view.findViewById(R.id.du6);
        this.C = (Switch) view.findViewById(R.id.f57932on);
        this.D = (Switch) view.findViewById(R.id.f57802oa);
        this.R = (Switch) view.findViewById(R.id.f57942oo);
        this.N = (Switch) view.findViewById(R.id.f57862og);
        Switch r16 = (Switch) view.findViewById(R.id.ws_);
        this.P = r16;
        r16.setChecked(j.b().a("guild_new_upload_media_service", false));
        this.P.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.feed.debug.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildDebugFragment.Lh(compoundButton, z16);
            }
        });
        findViewById.setOnClickListener(this);
        this.C.setOnCheckedChangeListener(this);
        this.D.setOnCheckedChangeListener(this);
        this.N.setOnCheckedChangeListener(this);
        Dh(view);
        Ch(view);
        Eh(view);
        Fh(view);
        Bh(view);
        this.R.setOnCheckedChangeListener(this);
        Switch r06 = (Switch) view.findViewById(R.id.f58062p0);
        this.S = r06;
        r06.setOnCheckedChangeListener(this);
        Switch r07 = (Switch) view.findViewById(R.id.f58052oz);
        this.T = r07;
        r07.setOnCheckedChangeListener(this);
        Switch r08 = (Switch) view.findViewById(R.id.f57792o_);
        this.U = r08;
        r08.setOnCheckedChangeListener(this);
        this.V = (EditText) view.findViewById(R.id.f57912ol);
        Button button = (Button) view.findViewById(R.id.f57892oj);
        this.W = button;
        button.setOnClickListener(this);
        this.X = (LinearLayout) view.findViewById(R.id.f57872oh);
        this.F = (TextView) view.findViewById(R.id.v36);
        this.G = (EditText) view.findViewById(R.id.f58022ow);
        view.findViewById(R.id.f58032ox).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f58042oy);
        this.f218412b0 = (Switch) linearLayout.findViewById(R.id.m_b);
        EditText editText = (EditText) linearLayout.findViewById(R.id.uoy);
        this.f218414d0 = editText;
        editText.addTextChangedListener(new a());
        this.f218412b0.setOnCheckedChangeListener(this);
        Switch r65 = (Switch) view.findViewById(R.id.f57732o4);
        this.f218413c0 = r65;
        r65.setOnCheckedChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setGuildSpeakManageGuideLastTime(VasUtil.getAppInterface().getCurrentAccountUin(), 0L);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        long j3;
        long j16;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (compoundButton == this.C) {
            j.b().e("key_html_offline_enabled", z16);
        } else if (compoundButton == this.D) {
            j.b().e("key_feed_detail_time_cost_view_enabled", z16);
        } else if (compoundButton == this.R) {
            Oh(z16);
        } else if (compoundButton == this.N) {
            j.b().e("key_feed_list_load_enabled", z16);
        } else if (compoundButton == this.S) {
            j.b().e("key_guild_trace_enabled", z16);
        } else if (compoundButton == this.T) {
            Nh(z16);
        } else if (compoundButton == this.U) {
            Mh(z16);
        } else if (compoundButton.getId() == R.id.f57812ob) {
            j.b().e("key_disable_aio_web_preload", z16);
        } else {
            x12.a aVar = this.Z;
            if (compoundButton == aVar.f446882y) {
                j.b().e("key_jump_debug_log_enabled", z16);
            } else if (compoundButton == aVar.f446872o) {
                j.b().e("key_empty_subscribe_guild_content", z16);
            } else if (compoundButton == aVar.f446871n) {
                j.b().e("key_disable_subscribe_guild_preload_switch", z16);
            } else if (compoundButton == aVar.f446874q) {
                j.b().e("KEY_ENABLE_STICKY_CARD_LIVE_VOICE", z16);
            } else if (compoundButton == aVar.f446873p) {
                j.b().e("KEY_ENABLE_NEW_USER_DISCOVER", z16);
            } else if (compoundButton == aVar.f446875r) {
                j.b().e("KEY_ENABLE_TOAST_FOR_TIANSHU", z16);
            } else if (compoundButton == aVar.f446870m) {
                IQQGuildSPUtilsApi iQQGuildSPUtilsApi = (IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class);
                String currentAccountUin = VasUtil.getAppInterface().getCurrentAccountUin();
                if (z16) {
                    j16 = -9999;
                } else {
                    j16 = 0;
                }
                iQQGuildSPUtilsApi.setGuildSpeakManageGuideLastTime(currentAccountUin, j16);
                j.b().e("key_disable_guild_speak_manage_guide_time_record", z16);
            } else if (compoundButton == aVar.A) {
                j.b().e("key_md_break_simple_enabled", z16);
            } else if (compoundButton == aVar.f446878u) {
                j.b().e("KEY_ENABLE_FEED_SQUARE_CLIP_INFO", z16);
            } else if (compoundButton == this.f218412b0) {
                j.b().e("KEY_ENABLE_GUILDTAB_METHOD_TRACE", z16);
                if (z16) {
                    try {
                        j3 = Long.parseLong(this.f218414d0.getText().toString());
                    } catch (NumberFormatException unused) {
                        j3 = 1000;
                    }
                    j.b().d("KEY_ENABLE_GUILDTAB_METHOD_TRACE_DURATION", String.valueOf(j3));
                }
            } else if (compoundButton == this.f218413c0) {
                j.b().e("key_always_show_guild_folder", z16);
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.du6) {
            getActivity().finish();
        } else if (view.getId() == R.id.f57982os) {
            QLogAnalysisTool.f218418a.m(view.getContext().getApplicationContext(), this.E.getText().toString(), this.K);
        } else if (view.getId() == R.id.v37) {
            j.b().d("key_feed_open_anim_duration", this.F.getText().toString());
        } else if (view.getId() == R.id.f58032ox) {
            ((IGuildRiskMemberApi) QRoute.api(IGuildRiskMemberApi.class)).changeMaxTinyIdCount(Integer.parseInt(this.G.getText().toString()));
        } else if (view.getId() == R.id.f57892oj) {
            GuildJumpUtil.w(getActivity(), this.V.getText().toString());
        } else if (view.getId() == R.id.wlz) {
            ((IContactExtApi) QRoute.api(IContactExtApi.class)).startGuildTestFragment(getContext());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        x12.a g16 = x12.a.g(layoutInflater, viewGroup, false);
        this.Z = g16;
        ScrollView root = g16.getRoot();
        this.Y = root;
        initView(root);
        Ah();
        initData();
        View view = this.Y;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            GuildDebugFragment.this.I.setSelection(i3);
            GuildDebugFragment.this.K = i3;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            long j3;
            try {
                j3 = Long.parseLong(GuildDebugFragment.this.f218414d0.getText().toString());
            } catch (NumberFormatException e16) {
                QLog.e("GuildDebugFragment", 1, "afterTextChanged: ", e16);
                j3 = -1;
            }
            if (j3 < 0) {
                return;
            }
            j.b().d("KEY_ENABLE_GUILDTAB_METHOD_TRACE_DURATION", String.valueOf(j3));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
