package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestionItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildWordQuestionItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchJoinGuildOptionRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class q extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    public static ViewModelProvider.Factory M = new a();
    private MutableLiveData<Boolean> C;
    private cn<cf1.b> D;
    private cn<Boolean> E;
    private String F;
    cn<Integer> G;
    cn<Integer> H;
    private ArrayList<GWGProJoinGuildWordQuestionItem> I;
    private ArrayList<GWGProJoinGuildChoiceQuestionItem> J;
    private boolean K;
    private String L;

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<IGProFetchJoinGuildOptionRsp> f233914i;

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<Integer> f233915m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new q(new wy1.a());
        }
    }

    public q(wy1.a aVar) {
        super(aVar);
        this.f233914i = new MutableLiveData<>();
        this.f233915m = new MutableLiveData<>();
        this.C = new MutableLiveData<>();
        this.D = new cn<>();
        this.E = new cn<>();
        this.F = "\u5185\u5bb9\u672a\u7f16\u8f91\u5b8c\u6210";
        this.G = new cn<>();
        this.H = new cn<>();
        this.I = new ArrayList<>();
        this.J = new ArrayList<>();
        this.L = "";
    }

    public void L1(int i3) {
        this.G.setValue(Integer.valueOf(i3));
        this.C.setValue(Boolean.FALSE);
    }

    public String M1() {
        return this.F;
    }

    public LiveData<Boolean> N1() {
        return this.E;
    }

    public LiveData<Boolean> O1() {
        return this.C;
    }

    public LiveData<cf1.b> P1() {
        return this.D;
    }

    public boolean Q1() {
        return this.K;
    }

    public void R1(int i3) {
        this.H.setValue(Integer.valueOf(i3));
    }

    public void S1(boolean z16) {
        this.E.setValue(Boolean.valueOf(z16));
    }

    public void T1(String str) {
        this.L = str;
    }

    public void U1(ArrayList<GWGProJoinGuildChoiceQuestionItem> arrayList) {
        this.J.clear();
        Iterator<GWGProJoinGuildChoiceQuestionItem> it = arrayList.iterator();
        while (it.hasNext()) {
            GWGProJoinGuildChoiceQuestionItem next = it.next();
            GWGProJoinGuildChoiceQuestionItem gWGProJoinGuildChoiceQuestionItem = new GWGProJoinGuildChoiceQuestionItem();
            gWGProJoinGuildChoiceQuestionItem.setAnswers((ArrayList) next.getAnswers().clone());
            gWGProJoinGuildChoiceQuestionItem.setQuestion(next.getQuestion());
            gWGProJoinGuildChoiceQuestionItem.setCorrectAnswer(next.getCorrectAnswer());
            this.J.add(gWGProJoinGuildChoiceQuestionItem);
        }
    }

    public void W1(ArrayList<GWGProJoinGuildWordQuestionItem> arrayList) {
        this.I.clear();
        Iterator<GWGProJoinGuildWordQuestionItem> it = arrayList.iterator();
        while (it.hasNext()) {
            GWGProJoinGuildWordQuestionItem next = it.next();
            GWGProJoinGuildWordQuestionItem gWGProJoinGuildWordQuestionItem = new GWGProJoinGuildWordQuestionItem();
            gWGProJoinGuildWordQuestionItem.setQuestion(next.getQuestion());
            gWGProJoinGuildWordQuestionItem.setCorrectAnswer(next.getCorrectAnswer());
            this.I.add(gWGProJoinGuildWordQuestionItem);
        }
    }

    public void X1(List<GWGProJoinGuildChoiceQuestionItem> list) {
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            GWGProJoinGuildChoiceQuestionItem gWGProJoinGuildChoiceQuestionItem = list.get(i3);
            if (arrayList.contains(gWGProJoinGuildChoiceQuestionItem.getQuestion())) {
                this.F = "\u5b58\u5728\u76f8\u540c\u95ee\u9898\uff0c\u8bf7\u4fee\u6539";
                z18 = true;
            } else {
                arrayList.add(gWGProJoinGuildChoiceQuestionItem.getQuestion());
            }
            if (gWGProJoinGuildChoiceQuestionItem.getQuestion().trim().isEmpty() || gWGProJoinGuildChoiceQuestionItem.getCorrectAnswer().trim().isEmpty()) {
                this.F = "\u5185\u5bb9\u672a\u7f16\u8f91\u5b8c\u6210";
                z17 = true;
            }
            if (gWGProJoinGuildChoiceQuestionItem.getAnswers().size() < 4) {
                this.F = "\u5185\u5bb9\u672a\u7f16\u8f91\u5b8c\u6210";
                z17 = true;
            }
            Iterator<String> it = gWGProJoinGuildChoiceQuestionItem.getAnswers().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (gWGProJoinGuildChoiceQuestionItem.getAnswers().indexOf(next) != gWGProJoinGuildChoiceQuestionItem.getAnswers().lastIndexOf(next)) {
                    this.F = "\u5b58\u5728\u76f8\u540c\u9009\u9879\uff0c\u8bf7\u4fee\u6539";
                    z19 = true;
                }
                if (next.trim().isEmpty()) {
                    this.F = "\u5185\u5bb9\u672a\u7f16\u8f91\u5b8c\u6210";
                    z17 = true;
                }
            }
            this.K = false;
            if (this.J.size() != list.size()) {
                this.K = true;
            } else {
                GWGProJoinGuildChoiceQuestionItem gWGProJoinGuildChoiceQuestionItem2 = this.J.get(i3);
                if (!gWGProJoinGuildChoiceQuestionItem.getQuestion().equals(gWGProJoinGuildChoiceQuestionItem2.getQuestion()) || !gWGProJoinGuildChoiceQuestionItem.getCorrectAnswer().equals(gWGProJoinGuildChoiceQuestionItem2.getCorrectAnswer())) {
                    this.K = true;
                }
                if (!gWGProJoinGuildChoiceQuestionItem.getAnswers().equals(gWGProJoinGuildChoiceQuestionItem2.getAnswers())) {
                    this.K = true;
                }
            }
        }
        MutableLiveData<Boolean> mutableLiveData = this.C;
        if (!z17 && !z18 && !z19) {
            z16 = true;
        }
        mutableLiveData.setValue(Boolean.valueOf(z16));
    }

    public void Z1(List<GWGProJoinGuildWordQuestionItem> list) {
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            GWGProJoinGuildWordQuestionItem gWGProJoinGuildWordQuestionItem = list.get(i3);
            if (arrayList.contains(gWGProJoinGuildWordQuestionItem.getQuestion())) {
                this.F = "\u5b58\u5728\u76f8\u540c\u95ee\u9898\uff0c\u8bf7\u4fee\u6539";
                z18 = true;
            } else {
                arrayList.add(gWGProJoinGuildWordQuestionItem.getQuestion());
            }
            if (gWGProJoinGuildWordQuestionItem.getQuestion().trim().isEmpty() || gWGProJoinGuildWordQuestionItem.getCorrectAnswer().trim().isEmpty()) {
                this.F = "\u5185\u5bb9\u672a\u7f16\u8f91\u5b8c\u6210";
                z17 = true;
            }
            this.K = false;
            if (this.I.size() != list.size()) {
                this.K = true;
            } else {
                GWGProJoinGuildWordQuestionItem gWGProJoinGuildWordQuestionItem2 = this.I.get(i3);
                if (!gWGProJoinGuildWordQuestionItem.getQuestion().equals(gWGProJoinGuildWordQuestionItem2.getQuestion()) || !gWGProJoinGuildWordQuestionItem.getCorrectAnswer().equals(gWGProJoinGuildWordQuestionItem2.getCorrectAnswer())) {
                    this.K = true;
                }
            }
        }
        this.G.setValue(Integer.valueOf(list.size()));
        MutableLiveData<Boolean> mutableLiveData = this.C;
        if (!z17 && !z18) {
            z16 = true;
        }
        mutableLiveData.setValue(Boolean.valueOf(z16));
    }
}
