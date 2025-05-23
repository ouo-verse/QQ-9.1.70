package android.content.res;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import org.xmlpull.v1.XmlPullParser;
import td0.g;
import ud0.c;

/* loaded from: classes.dex */
public class QUIProfileLayoutInflater extends LayoutInflater {
    private static final String TAG = "QUIProfileSkin_LayoutInflater";
    private final LayoutInflater mBase;
    private final Handler mHandler;
    private g mProfileDelegate;
    private final String mProfileId;
    private final be0.a mSkinManager;

    public QUIProfileLayoutInflater(LayoutInflater layoutInflater, Context context, String str) {
        super(layoutInflater, context);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mBase = layoutInflater;
        this.mProfileId = str;
        this.mSkinManager = be0.a.b(str);
    }

    public static QUIProfileLayoutInflater from(Context context, String str) {
        LayoutInflater from = LayoutInflater.from(context);
        if (from instanceof QUIProfileLayoutInflater) {
            return (QUIProfileLayoutInflater) from;
        }
        return new QUIProfileLayoutInflater(from, context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recursionTint(View view) {
        if (this.mSkinManager != null && view != null) {
            tintView(view);
            if (view instanceof ViewStub) {
                replaceViewStubLayoutInflater((ViewStub) view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    recursionTint(viewGroup.getChildAt(i3));
                }
            }
        }
    }

    private void replaceViewStubLayoutInflater(ViewStub viewStub) {
        LayoutInflater layoutInflater = viewStub.getLayoutInflater();
        if (layoutInflater != null && !(layoutInflater instanceof QUIProfileLayoutInflater)) {
            Context context = viewStub.getContext();
            if (context == null) {
                context = getContext();
            }
            viewStub.setLayoutInflater(new QUIProfileLayoutInflater(layoutInflater, context, this.mProfileId));
        }
    }

    private void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    private void tintBackground(View view) {
        Drawable e16;
        Drawable background = view.getBackground();
        if (background != null && (e16 = this.mSkinManager.e(view.getContext(), background)) != null && e16 != background) {
            view.setBackground(e16);
        }
    }

    private void tintCardView(CardView cardView) {
        ColorStateList d16;
        ColorStateList cardBackgroundColor = cardView.getCardBackgroundColor();
        if (cardBackgroundColor != null && (d16 = this.mSkinManager.d(cardBackgroundColor)) != null && d16 != cardBackgroundColor) {
            cardView.setCardBackgroundColor(d16);
        }
    }

    private void tintCompoundDrawables(TextView textView) {
        Drawable drawable;
        Context context = textView.getContext();
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length == 4 && ((drawable = compoundDrawables[0]) != null || compoundDrawables[1] != null || compoundDrawables[2] != null || compoundDrawables[3] != null)) {
            Drawable tintDrawable = tintDrawable(context, compoundDrawables[3]);
            Drawable[] drawableArr = {tintDrawable(context, drawable), tintDrawable(context, compoundDrawables[1]), tintDrawable(context, compoundDrawables[2]), tintDrawable};
            textView.setCompoundDrawables(drawableArr[0], drawableArr[1], drawableArr[2], tintDrawable);
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        if (compoundDrawablesRelative != null && compoundDrawablesRelative.length == 4) {
            Drawable drawable2 = compoundDrawablesRelative[0];
            if (drawable2 != null || compoundDrawablesRelative[2] != null) {
                Drawable tintDrawable2 = tintDrawable(context, compoundDrawablesRelative[2]);
                Drawable drawable3 = compoundDrawablesRelative[3];
                Drawable[] drawableArr2 = {tintDrawable(context, drawable2), compoundDrawablesRelative[1], tintDrawable2, drawable3};
                textView.setCompoundDrawablesRelative(drawableArr2[0], drawableArr2[1], tintDrawable2, drawable3);
            }
        }
    }

    private Drawable tintDrawable(Context context, Drawable drawable) {
        Drawable e16;
        if (drawable != null && (e16 = this.mSkinManager.e(context, drawable)) != null && e16 != drawable) {
            e16.setBounds(drawable.getBounds());
            return e16;
        }
        return drawable;
    }

    private void tintImageDrawable(ImageView imageView) {
        Drawable e16;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null && (e16 = this.mSkinManager.e(imageView.getContext(), drawable)) != null && e16 != drawable) {
            imageView.setImageDrawable(e16);
        }
    }

    private void tintTextColor(TextView textView) {
        ColorStateList d16;
        ColorStateList d17;
        ColorStateList d18;
        ColorStateList textColors = textView.getTextColors();
        if (textColors != null && (d18 = this.mSkinManager.d(textColors)) != null && d18 != textColors) {
            textView.setTextColor(d18);
        }
        ColorStateList linkTextColors = textView.getLinkTextColors();
        if (linkTextColors != null && (d17 = this.mSkinManager.d(linkTextColors)) != null && d17 != linkTextColors) {
            textView.setLinkTextColor(d17);
        }
        ColorStateList hintTextColors = textView.getHintTextColors();
        if (hintTextColors != null && (d16 = this.mSkinManager.d(hintTextColors)) != null && d16 != hintTextColors) {
            textView.setHintTextColor(d16);
        }
    }

    private void tintView(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            tintTextColor(textView);
            tintCompoundDrawables(textView);
        }
        if (view instanceof ImageView) {
            tintImageDrawable((ImageView) view);
        }
        if (view instanceof CardView) {
            tintCardView((CardView) view);
        }
        tintBackground(view);
        if (this.mProfileDelegate == null) {
            this.mProfileDelegate = (g) c.a(g.class);
        }
        g gVar = this.mProfileDelegate;
        if (gVar != null) {
            gVar.c(view, this.mProfileId);
        }
    }

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context context) {
        return new QUIProfileLayoutInflater(this, context, this.mProfileId);
    }

    @Override // android.view.LayoutInflater
    public View inflate(XmlPullParser xmlPullParser, @Nullable ViewGroup viewGroup, boolean z16) {
        final View inflate = this.mBase.inflate(xmlPullParser, viewGroup, z16);
        runOnUiThread(new Runnable() { // from class: android.content.res.QUIProfileLayoutInflater.1
            @Override // java.lang.Runnable
            public void run() {
                QUIProfileLayoutInflater.this.recursionTint(inflate);
            }
        });
        return inflate;
    }
}
