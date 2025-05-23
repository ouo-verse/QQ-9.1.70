package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ViewFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static Object f180849b;

    /* renamed from: c, reason: collision with root package name */
    private static ViewFactory f180850c;

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f180851d;

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f180852e;

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f180853f;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, WeakReference<View>> f180854a;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class GuideView extends LinearLayout implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        public static final int f180855f;

        /* renamed from: d, reason: collision with root package name */
        public b f180856d;

        /* renamed from: e, reason: collision with root package name */
        private int f180857e;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        public static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public int f180858a;

            /* renamed from: b, reason: collision with root package name */
            public int f180859b;

            public a(int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
                } else {
                    this.f180858a = i3;
                    this.f180859b = i16;
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes10.dex */
        public interface b {
            void a(int i3, String str);
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67852);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 7)) {
                redirector.redirect((short) 7);
            } else {
                f180855f = 2;
            }
        }

        public GuideView(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            } else {
                this.f180857e = -1;
                b(context);
            }
        }

        private void b(Context context) {
            setOrientation(1);
            LayoutInflater from = LayoutInflater.from(context);
            for (int i3 = 0; i3 < f180855f; i3++) {
                addView(from.inflate(R.layout.f167563at, (ViewGroup) this, false));
            }
        }

        private void c(ArrayList<a> arrayList, String str) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                childAt.setOnClickListener(this);
                childAt.setTag(Integer.valueOf(arrayList.get(i3).f180859b));
                childAt.setTag(arrayList.get(i3).f180859b, str);
                ((ImageView) childAt.findViewById(R.id.czi)).setImageResource(arrayList.get(i3).f180859b);
                ((TextView) childAt.findViewById(R.id.czx)).setText(childAt.getContext().getResources().getString(arrayList.get(i3).f180858a) + ":");
                ((TextView) childAt.findViewById(R.id.czn)).setText(str);
                childAt.setContentDescription(getResources().getString(arrayList.get(i3).f180858a) + ":" + str);
            }
        }

        private void e(String str) {
            String charSequence;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                childAt.setTag(((Integer) childAt.getTag()).intValue(), str);
                ((TextView) childAt.findViewById(R.id.czn)).setText(str);
                CharSequence contentDescription = childAt.getContentDescription();
                if (contentDescription == null) {
                    charSequence = "";
                } else {
                    charSequence = contentDescription.toString();
                }
                int length = charSequence.length();
                int indexOf = charSequence.indexOf(":");
                if (indexOf != -1 && indexOf != length - 1) {
                    childAt.setContentDescription(charSequence.substring(0, indexOf + 1) + str);
                }
            }
        }

        public a a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            switch (i3) {
                case 80000000:
                    return new a(R.string.f170094fo, R.drawable.qq_addfriend_search_friend);
                case 80000001:
                    return new a(R.string.f170096fq, R.drawable.qq_addfriend_search_group);
                case 80000002:
                    return new a(R.string.f170095fp, R.drawable.qq_addfriend_search_service);
                default:
                    return null;
            }
        }

        public void d(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
                return;
            }
            if (this.f180857e != i3) {
                ArrayList<a> arrayList = new ArrayList<>(3);
                for (int i16 : ViewFactory.i(i3)) {
                    arrayList.add(a(i16));
                }
                this.f180857e = i3;
                c(arrayList, str);
                return;
            }
            e(str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            } else {
                int intValue = ((Integer) view.getTag()).intValue();
                String str = (String) view.getTag(intValue);
                if (intValue == R.drawable.qq_addfriend_search_friend) {
                    intValue = 80000000;
                } else if (intValue == R.drawable.qq_addfriend_search_group) {
                    intValue = 80000001;
                } else if (intValue == R.drawable.qq_addfriend_search_service) {
                    intValue = 80000002;
                }
                b bVar = this.f180856d;
                if (bVar != null) {
                    bVar.a(intValue, str);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void setListener(b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            } else {
                this.f180856d = bVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ViewFactory.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ((InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67853);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f180849b = new Object();
        f180851d = new int[]{80000000, 80000001, 80000002, 80000004, 80000003};
        f180852e = new int[]{80000001, 80000000, 80000002, 80000004, 80000003};
        f180853f = new int[]{80000002, 80000000, 80000001, 80000004, 80000003};
    }

    ViewFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f180854a = new HashMap<>(5);
        }
    }

    private View c(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.f224626jf));
        textView.setTextSize(0, context.getResources().getDimension(R.dimen.ayn));
        textView.setPadding(0, context.getResources().getDimensionPixelSize(R.dimen.aj5), 0, 0);
        textView.setTextColor(context.getResources().getColor(R.color.skin_gray2_item));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        linearLayout.addView(textView, layoutParams);
        linearLayout.setContentDescription(context.getString(R.string.f224626jf));
        return linearLayout;
    }

    private View d(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.vn_);
        imageView.setImageResource(R.drawable.n7w);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.f224616je));
        textView.setTextSize(0, context.getResources().getDimension(R.dimen.ayn));
        textView.setPadding(0, BaseAIOUtils.f(30.0f, context.getResources()), 0, 0);
        textView.setTextColor(context.getResources().getColor(R.color.skin_gray2_item));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        linearLayout.addView(imageView, layoutParams2);
        linearLayout.addView(textView, layoutParams3);
        relativeLayout.addView(linearLayout, layoutParams);
        relativeLayout.setContentDescription(context.getString(R.string.f224616je));
        return relativeLayout;
    }

    private View e(Context context) {
        return new GuideView(context);
    }

    public static ViewFactory f() {
        if (f180850c == null) {
            synchronized (f180849b) {
                if (f180850c == null) {
                    f180850c = new ViewFactory();
                }
            }
        }
        return f180850c;
    }

    public static int g(int i3) {
        switch (i3) {
            case 80000000:
                return R.string.f170089fl;
            case 80000001:
                return R.string.f170121h4;
            case 80000002:
                if (UniteSearchActivity.f282684b0 == 12) {
                    return R.string.f170119h0;
                }
                return R.string.f170118gy;
            case 80000003:
                return R.string.f170097fs;
            case 80000004:
                return R.string.hvk;
            default:
                return R.string.f170106g9;
        }
    }

    private View h(Context context, WeakReference<IFaceDecoder> weakReference, List<x> list) {
        ListView listView = (ListView) LayoutInflater.from(context).inflate(R.layout.c2g, (ViewGroup) null);
        listView.setOnTouchListener(new a());
        jn2.c cVar = new jn2.c(listView, weakReference.get(), null, -1);
        listView.setAdapter((ListAdapter) cVar);
        cVar.g(SearchUtil.l(list, true));
        return listView;
    }

    public static int[] i(int i3) {
        switch (i3) {
            case 80000000:
                return f180851d;
            case 80000001:
                return f180852e;
            case 80000002:
                return f180853f;
            case 80000003:
                return f180851d;
            default:
                return f180851d;
        }
    }

    public View a(int i3, Context context, boolean z16, IFaceDecoder iFaceDecoder, List<x> list) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), context, Boolean.valueOf(z16), iFaceDecoder, list);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ViewFactory", 2, "type = " + i3);
        }
        if (z16 && this.f180854a.get(Integer.valueOf(i3)) != null) {
            view = this.f180854a.get(Integer.valueOf(i3)).get();
        } else {
            view = null;
            z17 = false;
        }
        if (view == null) {
            switch (i3) {
                case 80000005:
                    view = e(context);
                    break;
                case 80000006:
                    view = c(context);
                    break;
                case 80000007:
                    view = d(context);
                    break;
                case 80000008:
                    view = h(context, new WeakReference<>(iFaceDecoder), list);
                    break;
            }
        }
        if (z16 && !z17) {
            this.f180854a.put(Integer.valueOf(i3), new WeakReference<>(view));
        }
        return view;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f180850c = null;
        this.f180854a.clear();
        this.f180854a = null;
    }
}
