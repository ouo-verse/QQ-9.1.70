package com.tencent.tuxmetersdk.jwt;

import android.util.Base64;
import com.google.gson.Gson;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.jwt.algorithms.Algorithm;
import com.tencent.tuxmetersdk.jwt.exceptions.JWTCreationException;
import com.tencent.tuxmetersdk.jwt.exceptions.SignatureGenerationException;
import com.tencent.tuxmetersdk.jwt.impl.HeaderClaimsHolder;
import com.tencent.tuxmetersdk.jwt.impl.PayloadClaimsHolder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JWTCreator {
    static IPatchRedirector $redirector_;
    private final Algorithm algorithm;
    private final String headerJson;
    private final String payloadJson;

    /* synthetic */ JWTCreator(Algorithm algorithm, Map map, Map map2, AnonymousClass1 anonymousClass1) throws JWTCreationException {
        this(algorithm, map, map2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, algorithm, map, map2, anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Builder init() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String sign() throws SignatureGenerationException {
        String encodeToString = Base64.encodeToString(this.headerJson.getBytes(StandardCharsets.UTF_8), 11);
        String encodeToString2 = Base64.encodeToString(this.payloadJson.getBytes(StandardCharsets.UTF_8), 11);
        return String.format("%s.%s.%s", encodeToString, encodeToString2, Base64.encodeToString(this.algorithm.sign(encodeToString.getBytes(StandardCharsets.UTF_8), encodeToString2.getBytes(StandardCharsets.UTF_8)), 11));
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final Map<String, Object> headerClaims;
        private final Map<String, Object> payloadClaims;

        Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.payloadClaims = new HashMap();
                this.headerClaims = new HashMap();
            }
        }

        private void addClaim(String str, Object obj) {
            this.payloadClaims.put(str, obj);
        }

        private void assertNonNull(String str) {
            if (str != null) {
            } else {
                throw new IllegalArgumentException("The Custom Claim's name can't be null.");
            }
        }

        private static boolean isBasicType(Object obj) {
            if (obj == null) {
                return true;
            }
            Class<?> cls = obj.getClass();
            if (cls.isArray()) {
                if (cls == Integer[].class || cls == Long[].class || cls == String[].class) {
                    return true;
                }
                return false;
            }
            if (cls == String.class || cls == Integer.class || cls == Long.class || cls == Double.class || cls == Date.class || cls == Boolean.class) {
                return true;
            }
            return false;
        }

        private static boolean isSupportedType(Object obj) {
            if (obj instanceof List) {
                return validateClaim((List<?>) obj);
            }
            if (obj instanceof Map) {
                return validateClaim((Map<?, ?>) obj);
            }
            return isBasicType(obj);
        }

        private static boolean validateClaim(Map<?, ?> map) {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (!isSupportedType(entry.getValue()) || entry.getKey() == null || !(entry.getKey() instanceof String)) {
                    return false;
                }
            }
            return true;
        }

        private boolean validatePayload(Map<String, ?> map) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                assertNonNull(entry.getKey());
                Object value = entry.getValue();
                if ((value instanceof List) && !validateClaim((List<?>) value)) {
                    return false;
                }
                if (((value instanceof Map) && !validateClaim((Map<?, ?>) value)) || !isSupportedType(value)) {
                    return false;
                }
            }
            return true;
        }

        public String sign(Algorithm algorithm) throws IllegalArgumentException, JWTCreationException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (String) iPatchRedirector.redirect((short) 23, (Object) this, (Object) algorithm);
            }
            if (algorithm != null) {
                this.headerClaims.put(HeaderParams.ALGORITHM, algorithm.getName());
                if (!this.headerClaims.containsKey(HeaderParams.TYPE)) {
                    this.headerClaims.put(HeaderParams.TYPE, "JWT");
                }
                String signingKeyId = algorithm.getSigningKeyId();
                if (signingKeyId != null) {
                    withKeyId(signingKeyId);
                }
                return new JWTCreator(algorithm, this.headerClaims, this.payloadClaims, null).sign();
            }
            throw new IllegalArgumentException("The Algorithm cannot be null.");
        }

        public Builder withArrayClaim(String str, String[] strArr) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (Builder) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) strArr);
            }
            assertNonNull(str);
            addClaim(str, strArr);
            return this;
        }

        public Builder withAudience(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) strArr);
            }
            addClaim(RegisteredClaims.AUDIENCE, strArr);
            return this;
        }

        public Builder withClaim(String str, Boolean bool) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) bool);
            }
            assertNonNull(str);
            addClaim(str, bool);
            return this;
        }

        public Builder withExpiresAt(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) date);
            }
            addClaim(RegisteredClaims.EXPIRES_AT, Long.valueOf(date.getTime() / 1000));
            return this;
        }

        public Builder withHeader(Map<String, Object> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            }
            if (map == null) {
                return this;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() == null) {
                    this.headerClaims.remove(entry.getKey());
                } else {
                    this.headerClaims.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public Builder withIssuedAt(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) date);
            }
            addClaim(RegisteredClaims.ISSUED_AT, Long.valueOf(date.getTime() / 1000));
            return this;
        }

        public Builder withIssuer(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            addClaim(RegisteredClaims.ISSUER, str);
            return this;
        }

        public Builder withJWTId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            }
            addClaim(RegisteredClaims.JWT_ID, str);
            return this;
        }

        public Builder withKeyId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.headerClaims.put(HeaderParams.KEY_ID, str);
            return this;
        }

        public Builder withNullClaim(String str) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            }
            assertNonNull(str);
            addClaim(str, null);
            return this;
        }

        public Builder withPayload(Map<String, ?> map) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (Builder) iPatchRedirector.redirect((short) 22, (Object) this, (Object) map);
            }
            if (map == null) {
                return this;
            }
            if (validatePayload(map)) {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    addClaim(entry.getKey(), entry.getValue());
                }
                return this;
            }
            throw new IllegalArgumentException("Claim values must only be of types Map, List, Boolean, Integer, Long, Double, String, Date, and Null");
        }

        public Builder withSubject(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            addClaim(RegisteredClaims.SUBJECT, str);
            return this;
        }

        public Builder withArrayClaim(String str, Integer[] numArr) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Builder) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) numArr);
            }
            assertNonNull(str);
            addClaim(str, numArr);
            return this;
        }

        public Builder withClaim(String str, Integer num) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) num);
            }
            assertNonNull(str);
            addClaim(str, num);
            return this;
        }

        private static boolean validateClaim(List<?> list) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                if (!isSupportedType(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public Builder withArrayClaim(String str, Long[] lArr) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (Builder) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, (Object) lArr);
            }
            assertNonNull(str);
            addClaim(str, lArr);
            return this;
        }

        public Builder withClaim(String str, Long l3) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) l3);
            }
            assertNonNull(str);
            addClaim(str, l3);
            return this;
        }

        public Builder withClaim(String str, Double d16) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) d16);
            }
            assertNonNull(str);
            addClaim(str, d16);
            return this;
        }

        public Builder withClaim(String str, String str2) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2);
            }
            assertNonNull(str);
            addClaim(str, str2);
            return this;
        }

        public Builder withClaim(String str, Date date) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) date);
            }
            assertNonNull(str);
            addClaim(str, date);
            return this;
        }

        public Builder withClaim(String str, Map<String, ?> map) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) map);
            }
            assertNonNull(str);
            if (map != null && !validateClaim(map)) {
                throw new IllegalArgumentException("Expected map containing Map, List, Boolean, Integer, Long, Double, String and Date");
            }
            addClaim(str, map);
            return this;
        }

        public Builder withClaim(String str, List<?> list) throws IllegalArgumentException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) list);
            }
            assertNonNull(str);
            if (list != null && !validateClaim(list)) {
                throw new IllegalArgumentException("Expected list containing Map, List, Boolean, Integer, Long, Double, String and Date");
            }
            addClaim(str, list);
            return this;
        }
    }

    JWTCreator(Algorithm algorithm, Map<String, Object> map, Map<String, Object> map2) throws JWTCreationException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, algorithm, map, map2);
            return;
        }
        this.algorithm = algorithm;
        try {
            Gson gson = new Gson();
            this.headerJson = gson.toJson(new HeaderClaimsHolder(map).getClaims());
            this.payloadJson = gson.toJson(new PayloadClaimsHolder(map2).getClaims());
        } catch (Exception e16) {
            throw new JWTCreationException("Some of the Claims couldn't be converted to a valid JSON format.", e16);
        }
    }
}
