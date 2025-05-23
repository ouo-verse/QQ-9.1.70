package org.jf.dexlib2.iface.reference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface Reference {
    void validateReference() throws InvalidReferenceException;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class InvalidReferenceException extends Exception {
        private final String invalidReferenceRepresentation;

        public InvalidReferenceException(String str) {
            super("Invalid reference");
            this.invalidReferenceRepresentation = str;
        }

        public String getInvalidReferenceRepresentation() {
            return this.invalidReferenceRepresentation;
        }

        public InvalidReferenceException(String str, String str2) {
            super(str2);
            this.invalidReferenceRepresentation = str;
        }

        public InvalidReferenceException(String str, String str2, Throwable th5) {
            super(str2, th5);
            this.invalidReferenceRepresentation = str;
        }

        public InvalidReferenceException(String str, Throwable th5) {
            super(th5);
            this.invalidReferenceRepresentation = str;
        }
    }
}
