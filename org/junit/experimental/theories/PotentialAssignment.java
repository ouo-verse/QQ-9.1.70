package org.junit.experimental.theories;

/* loaded from: classes29.dex */
public abstract class PotentialAssignment {

    /* loaded from: classes29.dex */
    public static class CouldNotGenerateValueException extends Exception {
        private static final long serialVersionUID = 1;

        public CouldNotGenerateValueException() {
        }

        public CouldNotGenerateValueException(Throwable th5) {
            super(th5);
        }
    }

    public static PotentialAssignment forValue(final String str, final Object obj) {
        return new PotentialAssignment() { // from class: org.junit.experimental.theories.PotentialAssignment.1
            @Override // org.junit.experimental.theories.PotentialAssignment
            public String getDescription() {
                String format;
                Object obj2 = obj;
                if (obj2 == null) {
                    format = "null";
                } else {
                    try {
                        format = String.format("\"%s\"", obj2);
                    } catch (Throwable th5) {
                        format = String.format("[toString() threw %s: %s]", th5.getClass().getSimpleName(), th5.getMessage());
                    }
                }
                return String.format("%s <from %s>", format, str);
            }

            @Override // org.junit.experimental.theories.PotentialAssignment
            public Object getValue() {
                return obj;
            }

            public String toString() {
                return String.format("[%s]", obj);
            }
        };
    }

    public abstract String getDescription() throws CouldNotGenerateValueException;

    public abstract Object getValue() throws CouldNotGenerateValueException;
}
