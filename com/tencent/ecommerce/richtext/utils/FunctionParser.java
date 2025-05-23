package com.tencent.ecommerce.richtext.utils;

import android.support.annotation.NonNull;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class FunctionParser<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private c<K, V> f105484a;

    /* renamed from: b, reason: collision with root package name */
    private b f105485b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum Token {
        FUNC_NAME,
        PARAM_VALUE,
        LEFT_PARENT,
        RIGHT_PARENT,
        COMMA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f105486a;

        /* renamed from: b, reason: collision with root package name */
        private Token f105487b;

        /* renamed from: c, reason: collision with root package name */
        private String f105488c;

        /* renamed from: d, reason: collision with root package name */
        private int f105489d;

        /* JADX INFO: Access modifiers changed from: private */
        public Token d() {
            return this.f105487b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String e() {
            return this.f105488c;
        }

        private boolean f(char c16) {
            if (('0' <= c16 && c16 <= '9') || (('a' <= c16 && c16 <= 'z') || ('A' <= c16 && c16 <= 'Z'))) {
                return true;
            }
            return false;
        }

        private boolean g(CharSequence charSequence) {
            for (int i3 = 0; i3 < charSequence.length(); i3++) {
                char charAt = charSequence.charAt(i3);
                if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && charAt != '-')) {
                    return false;
                }
            }
            return true;
        }

        private void h(String str) {
            if ("(".equals(str)) {
                this.f105487b = Token.LEFT_PARENT;
                this.f105488c = "(";
                return;
            }
            if (")".equals(str)) {
                this.f105487b = Token.RIGHT_PARENT;
                this.f105488c = ")";
            } else if (",".equals(str)) {
                this.f105487b = Token.COMMA;
                this.f105488c = ",";
            } else if (g(str)) {
                this.f105487b = Token.FUNC_NAME;
                this.f105488c = str;
            } else {
                this.f105487b = Token.PARAM_VALUE;
                this.f105488c = str;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean i() {
            int i3 = this.f105489d;
            while (true) {
                if (this.f105489d >= this.f105486a.length()) {
                    break;
                }
                char charAt = this.f105486a.charAt(this.f105489d);
                if (charAt == ' ') {
                    int i16 = this.f105489d;
                    this.f105489d = i16 + 1;
                    if (i3 != i16) {
                        break;
                    }
                    i3++;
                } else if (!f(charAt) && charAt != '.' && charAt != '%' && charAt != '-' && charAt != '+') {
                    int i17 = this.f105489d;
                    if (i3 == i17) {
                        this.f105489d = i17 + 1;
                    }
                } else {
                    this.f105489d++;
                }
            }
            int i18 = this.f105489d;
            if (i3 != i18) {
                h(this.f105486a.substring(i3, i18));
                return true;
            }
            this.f105487b = null;
            this.f105488c = null;
            return false;
        }

        b(String str) {
            this.f105489d = 0;
            this.f105486a = str;
        }
    }

    /* loaded from: classes5.dex */
    public interface c<K, V> {
        Map<K, V> a(String str, List<String> list);
    }

    public FunctionParser(@NonNull String str, @NonNull c<K, V> cVar) {
        this.f105485b = new b(str);
        this.f105484a = cVar;
    }

    private LinkedHashMap<K, V> a() {
        LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<>();
        do {
            linkedHashMap.putAll(b());
        } while (this.f105485b.d() == Token.FUNC_NAME);
        return linkedHashMap;
    }

    private Map<K, V> b() {
        LinkedList linkedList = new LinkedList();
        String c16 = c(Token.FUNC_NAME);
        c(Token.LEFT_PARENT);
        linkedList.add(c(Token.PARAM_VALUE));
        while (true) {
            Token d16 = this.f105485b.d();
            Token token = Token.COMMA;
            if (d16 == token) {
                c(token);
                linkedList.add(c(Token.PARAM_VALUE));
            } else {
                c(Token.RIGHT_PARENT);
                return this.f105484a.a(c16, linkedList);
            }
        }
    }

    private String c(Token token) {
        if (token == this.f105485b.d()) {
            String e16 = this.f105485b.e();
            this.f105485b.i();
            return e16;
        }
        return "";
    }

    public LinkedHashMap<K, V> d() {
        this.f105485b.i();
        return a();
    }
}
