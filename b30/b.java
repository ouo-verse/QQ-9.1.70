package b30;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.dataline.util.j;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.debug.recommend.data.RecExptInfo;
import com.tencent.biz.qqcircle.f;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.config.RFWCommonConfig;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.utils.ArrayUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.common.event.RFRestartAppEvent;
import com.tencent.richframework.common.request.RFWCommonGetRainbowKVConfRequest;
import java.util.ArrayList;
import java.util.List;
import k30.e;
import qqcircle.QQCircleConfig$GetRainbowKVConfRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends BlockPart implements View.OnClickListener {
    private String C;

    @SuppressLint({"WrongConstant"})
    private SharedPreferences D;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f27794d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f27795e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f27796f;

    /* renamed from: h, reason: collision with root package name */
    private RadioGroup f27797h;

    /* renamed from: i, reason: collision with root package name */
    private List<RecExptInfo> f27798i;

    /* renamed from: m, reason: collision with root package name */
    private RecExptInfo f27799m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i3) {
            EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
            b bVar = b.this;
            bVar.f27799m = bVar.G9(i3);
            if (b.this.f27799m != null) {
                b.this.showConfirmDialog();
            }
            EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: b30.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0090b implements VSDispatchObserver.OnVSRspCallBack<QQCircleConfig$GetRainbowKVConfRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27801a;

        C0090b(String str) {
            this.f27801a = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleConfig$GetRainbowKVConfRsp qQCircleConfig$GetRainbowKVConfRsp) {
            String str2;
            QLog.i("RFWChangeMsfServerPart", 1, "GetRainbowKVConfRsp isSuccess\uff1a" + z16 + " errormsg:" + str + " retCode:" + j3);
            if (z16 && qQCircleConfig$GetRainbowKVConfRsp != null && !TextUtils.isEmpty(qQCircleConfig$GetRainbowKVConfRsp.data.get())) {
                str2 = qQCircleConfig$GetRainbowKVConfRsp.data.get();
                f.X(str2);
            } else {
                str2 = this.f27801a;
            }
            b.this.onConfReceive(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            b.this.restartApp();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public b() {
        String str;
        if (QCirclePluginGlobalInfo.k() == null) {
            str = "";
        } else {
            str = QCirclePluginGlobalInfo.k().jsonString;
        }
        this.C = str;
        this.D = RFWCommonConfig.getShareSp();
    }

    private RadioButton F9(RecExptInfo recExptInfo, boolean z16) {
        RadioButton radioButton = new RadioButton(getContext());
        radioButton.setText(recExptInfo.exptName);
        radioButton.setChecked(z16);
        radioButton.setTextColor(R.color.coa);
        radioButton.setPadding(30, 0, 0, 0);
        return radioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecExptInfo G9(int i3) {
        if (ArrayUtils.isOutOfArrayIndex(i3, this.f27798i)) {
            return null;
        }
        return this.f27798i.get(i3);
    }

    @NonNull
    private ArrayList<RecExptInfo> H9() {
        ArrayList<RecExptInfo> arrayList = new ArrayList<>();
        arrayList.add(RecExptInfo.obtainDefault());
        return arrayList;
    }

    private void I9(List<RecExptInfo> list) {
        this.f27797h.removeAllViews();
        for (int i3 = 0; i3 < list.size(); i3++) {
            RecExptInfo recExptInfo = list.get(i3);
            final RadioButton F9 = F9(recExptInfo, recExptInfo.jsonString.equals(this.C));
            F9.setId(i3);
            F9.setTag(recExptInfo);
            this.f27797h.addView(F9, new RadioGroup.LayoutParams(-1, -2));
            if (!TextUtils.isEmpty(recExptInfo.exptIntro)) {
                TextView textView = new TextView(getContext());
                textView.setText(recExptInfo.exptIntro);
                textView.setTextColor(R.color.coa);
                textView.setOnClickListener(new View.OnClickListener() { // from class: b30.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        b.J9(F9, view);
                    }
                });
                this.f27797h.addView(textView, new RadioGroup.LayoutParams(-1, -2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J9(RadioButton radioButton, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        radioButton.performClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void destroy() {
        if (!getPartManager().onBackEvent() && getActivity() != null) {
            getActivity().finish();
        }
    }

    private void initData() {
        setTvTipsVisiable("\u914d\u7f6e\u52a0\u8f7d\u4e2d\u2026\u2026");
        VSNetworkHelper.getInstance().sendRequest(new RFWCommonGetRainbowKVConfRequest("4a210ffa-7805-45f0-8a72-11b05aeea386", "wenan1", "exp_conf_list"), new C0090b(f.F()));
    }

    private void initRadioGroup() {
        this.f27797h.setOnCheckedChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConfReceive(String str) {
        if (TextUtils.isEmpty(str)) {
            setTvTipsVisiable("\u540e\u53f0\u8fd4\u56de\u914d\u7f6e\u4e3a\u7a7a");
            return;
        }
        try {
            Gson gson = new Gson();
            JsonElement jsonElement = new JsonParser().parse(str).getAsJsonObject().get("exp_list");
            this.f27798i = H9();
            if (jsonElement.isJsonArray()) {
                JsonArray asJsonArray = jsonElement.getAsJsonArray();
                int size = asJsonArray.size();
                for (int i3 = 0; i3 < size; i3++) {
                    JsonElement jsonElement2 = asJsonArray.get(i3);
                    RecExptInfo recExptInfo = (RecExptInfo) gson.fromJson(jsonElement2, RecExptInfo.class);
                    recExptInfo.jsonString = jsonElement2.toString();
                    this.f27798i.add(recExptInfo);
                }
            } else if (jsonElement.isJsonObject()) {
                RecExptInfo recExptInfo2 = (RecExptInfo) gson.fromJson(jsonElement, RecExptInfo.class);
                recExptInfo2.jsonString = recExptInfo2.toString();
                this.f27798i.add(recExptInfo2);
            }
            List<RecExptInfo> list = this.f27798i;
            if (list != null && list.size() > 0) {
                I9(this.f27798i);
            }
            setTvTipsVisiable("");
        } catch (Exception unused) {
            setTvTipsVisiable("\u540e\u53f0\u914d\u7f6e\u89e3\u6790\u9519\u8bef");
            f.X("");
            QLog.i("RFWChangeMsfServerPart", 1, "GetRainbowKVConfRsp json exception!\uff1a json is:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartApp() {
        if (this.f27799m == null) {
            return;
        }
        f.W(new Gson().toJson(this.f27799m));
        QCirclePluginGlobalInfo.S(this.f27799m);
        SimpleEventBus.getInstance().dispatchEvent(new RFRestartAppEvent());
        e.i().f();
    }

    private void setTvTipsVisiable(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f27796f.setVisibility(8);
        } else {
            this.f27796f.setText(str);
            this.f27796f.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirmDialog() {
        RecExptInfo recExptInfo = this.f27799m;
        if (recExptInfo != null && !this.C.equals(recExptInfo.jsonString)) {
            QCircleCustomDialog.P(getContext(), "\u63a8\u8350\u5b9e\u9a8c\u73af\u5883\u6539\u53d8", j.d("\u662f\u5426\u91cd\u8fdb\u5c0f\u4e16\u754c\u4ee5\u751f\u6548?"), R.string.cancel, R.string.f170648xe, new c(), new d()).show();
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "RFWChangeMsfServerPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.y_2) {
            destroy();
        } else if (id5 == R.id.f73643u4) {
            restartApp();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.y_2);
        this.f27794d = imageView;
        imageView.setOnClickListener(this);
        this.f27796f = (TextView) view.findViewById(R.id.kbr);
        TextView textView = (TextView) view.findViewById(R.id.kbs);
        this.f27795e = textView;
        textView.setText("\u63a8\u8350\u5b9e\u9a8c\u73af\u5883");
        this.f27797h = (RadioGroup) view.findViewById(R.id.f74173vj);
        initRadioGroup();
        initData();
    }
}
