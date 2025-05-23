package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AuthorizationItem extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    public static final ItemType ITEM_TYPE_NONE;
    public static final ItemType ITEM_TYPE_PHONE;
    public static final ItemType ITEM_TYPE_PLACE;
    public static final ItemType ITEM_TYPE_USER_NAME;
    public static final int POSITION_BOTH = 3;
    public static final int POSITION_BOTTOM = 2;
    public static final int POSITION_MIDDLE = 1;
    public static final int POSITION_TOP = 0;
    private String mContent;
    private ItemType mItemType;
    private int mPositionType;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ItemType {
        static IPatchRedirector $redirector_;
        public final String itemName;
        public final String key;
        public final int typeValue;

        ItemType(String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3));
                return;
            }
            this.itemName = str;
            this.key = str2;
            this.typeValue = i3;
        }

        public static ItemType fromValue(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return AuthorizationItem.ITEM_TYPE_NONE;
                    }
                    return AuthorizationItem.ITEM_TYPE_PLACE;
                }
                return AuthorizationItem.ITEM_TYPE_PHONE;
            }
            return AuthorizationItem.ITEM_TYPE_USER_NAME;
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes27.dex */
    @interface PositionType {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51614);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        ITEM_TYPE_USER_NAME = new ItemType("\u6635\u79f0  ", "key_authorize_user_name", 0);
        ITEM_TYPE_PHONE = new ItemType("\u624b\u673a\u53f7", "key_authorize_phone", 1);
        ITEM_TYPE_PLACE = new ItemType("\u7701\u5e02\u533a", "key_authorize_place", 2);
        ITEM_TYPE_NONE = new ItemType("", "", -1);
    }

    public AuthorizationItem(Context context, String str, ItemType itemType, int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, itemType, Integer.valueOf(i3));
            return;
        }
        this.mItemType = itemType;
        this.mPositionType = i3;
        this.mContent = str;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.cay, (ViewGroup) this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.D);
            this.mPositionType = obtainStyledAttributes.getInteger(jj2.b.E, -1);
            this.mItemType = ItemType.fromValue(obtainStyledAttributes.getInteger(jj2.b.G, -1));
            this.mContent = obtainStyledAttributes.getString(jj2.b.F);
            obtainStyledAttributes.recycle();
        }
        setPositionType(this.mPositionType);
        setItemType(this.mItemType);
        setContent(this.mContent);
    }

    public void setContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str)) {
            ((TextView) findViewById(R.id.md7)).setText(str);
        }
    }

    public void setItemType(ItemType itemType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) itemType);
        } else {
            ((TextView) findViewById(R.id.md8)).setText(itemType.itemName);
        }
    }

    public void setPositionType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (i3 == 0) {
            setBackgroundResource(R.drawable.hg6);
            return;
        }
        if (i3 == 1) {
            setBackgroundResource(R.drawable.hg5);
        } else if (i3 == 2) {
            setBackgroundResource(R.drawable.f161716hg3);
        } else if (i3 == 3) {
            setBackgroundResource(R.drawable.f161715hg2);
        }
    }

    public AuthorizationItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            init(context, attributeSet);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public AuthorizationItem(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init(context, attributeSet);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
